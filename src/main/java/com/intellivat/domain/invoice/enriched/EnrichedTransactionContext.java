package com.intellivat.domain.invoice.enriched;

import com.intellivat.domain.invoice.ChainTransaction;
import com.intellivat.domain.invoice.schema.*;
import com.intellivat.domain.masterdata.Location;

import java.time.LocalDate;
import java.util.Optional;

import static com.intellivat.domain.invoice.schema.CommonPretaxMapper.toPretaxLocation;

/**
 * The {@code TransactionContext} holds the information of the underlying physical transaction. It describes for
 * instance from where goods have been shipped and to where, which leg of a total transport the seller (a carrier) is
 * invoicing or where a service has been fulfilled.
 * 
 * @author Alex Rommel
 */
public class EnrichedTransactionContext {

    private Location senderLocation;

    private Location receiverLocation;

    private LocalDate dispatchDate;

    private LocalDate deliverDate;

    private Location serviceRenderedArea;

    private Location serviceProviderLocation;

    //TODO: replace with own type that is not dependent on schema, maybe inner enum
    private TransactionContext.TransactionContextType type;

    private boolean intoBond;

    private boolean outOfBond;

    private Optional<ChainTransaction> chainTransaction = Optional.empty();

    private Optional<EnrichedShipment> shipment = Optional.empty();

    /**
     * Copy constructor
     */
    public EnrichedTransactionContext( EnrichedTransactionContext ctx ) {
        if ( ctx != null ) {
            this.senderLocation = ctx.senderLocation;
            this.receiverLocation = ctx.receiverLocation;
            this.dispatchDate = ctx.dispatchDate;
            this.deliverDate = ctx.deliverDate;
            this.serviceRenderedArea = ctx.serviceRenderedArea;
            this.serviceProviderLocation = ctx.serviceProviderLocation;
            this.chainTransaction = ctx.chainTransaction;
            this.shipment = ctx.shipment;
            this.type = ctx.type;
            this.intoBond = ctx.intoBond;
            this.outOfBond = ctx.outOfBond;
        }
    }

    public EnrichedTransactionContext( Location senderLocation, Location receiverLocation,
                                       Location serviceRenderedArea, Location serviceProviderLocation,
                                       ChainTransaction chainTransaction, EnrichedShipment shipment,
                                       TransactionContext.TransactionContextType type,
                                       boolean intoBond, boolean outOfBond){
        this.senderLocation = senderLocation;
        this.receiverLocation = receiverLocation;
        this.serviceRenderedArea = serviceRenderedArea;
        this.serviceProviderLocation = serviceProviderLocation;
        this.chainTransaction = Optional.ofNullable(chainTransaction);
        this.shipment = Optional.ofNullable(shipment);
        this.type = type;
        this.intoBond = intoBond;
        this.outOfBond = outOfBond;
    }


    /**
     * Default constructor
     */
    EnrichedTransactionContext() {}

    public Location getSenderLocation() {
        return senderLocation;
    }

    public void setSenderLocation( Location senderLocation) {
        this.senderLocation = senderLocation;
    }

    public Location getReceiverLocation() {
        return receiverLocation;
    }

    public void setReceiverLocation( Location receiverLocation ) {
        this.receiverLocation = receiverLocation;
    }

    public LocalDate getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate( LocalDate dispatchDate ) {
        this.dispatchDate = dispatchDate;
    }

    public LocalDate getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate( LocalDate deliverDate ) {
        this.deliverDate = deliverDate;
    }

    public Location getServiceRenderedArea() {
        return serviceRenderedArea;
    }

    public void setServiceRenderedArea( Location serviceRenderedArea ) {
        this.serviceRenderedArea = serviceRenderedArea;
    }

    public ChainTransaction getChainTransaction() {
        return chainTransaction.orElse( null );
    }

    public void setChainTransaction( ChainTransaction chainTransaction ) {
        this.chainTransaction = Optional.ofNullable( chainTransaction );
    }

    public EnrichedShipment getShipment() {
        return shipment.orElse( null );
    }

    public void setShipment( EnrichedShipment shipment ) {
        this.shipment = Optional.ofNullable( shipment );
    }

    public Location getServiceProviderLocation() {
        return serviceProviderLocation;
    }

    public void setServiceProviderLocation(Location serviceProviderLocation) {
        this.serviceProviderLocation = serviceProviderLocation;
    }

    public TransactionContext.TransactionContextType getType() {
        return type;
    }

    public void setType( TransactionContext.TransactionContextType type ) {
        this.type = type;
    }

    public boolean isIntoBond() {
        return intoBond;
    }

    public void setIntoBond( boolean intoBond ) {
        this.intoBond = intoBond;
    }

    public boolean isOutOfBond() {
        return outOfBond;
    }

    public void setOutOfBond( boolean outOfBond ) {
        this.outOfBond = outOfBond;
    }

    public TransactionContext toTransactionContext() {

        TransactionContext context = new TransactionContext();

        chainTransaction.ifPresent(ct -> {
            PretaxChainTransaction pretaxChaintransaction = new PretaxChainTransaction();
            pretaxChaintransaction.setExport(ct.isExport());
            pretaxChaintransaction.setExported(ct.isExported());
            pretaxChaintransaction.setImport(ct.isImport());
            pretaxChaintransaction.setImported(ct.isImported());
            context.setChainTransaction(pretaxChaintransaction);
        });

        if (senderLocation != null || receiverLocation != null){
            PretaxDelivery delivery = new PretaxDelivery();
            context.setDelivery(delivery);
            if (senderLocation != null) {
                delivery.setSenderLocation(toPretaxLocation(senderLocation));
            }
            if (receiverLocation != null) {
                delivery.setReceiverLocation(toPretaxLocation(receiverLocation));
            }
            delivery.setIntoBond( intoBond );
            delivery.setOutOfBond( outOfBond );
            addShipmentLegTo(delivery);
        }

        if (serviceProviderLocation != null){
            Service service = new Service();
            context.setService(service);
            service.setServiceLocation(toPretaxLocation(serviceRenderedArea));
            service.setServiceProviderLocation(toPretaxLocation(serviceProviderLocation));
        }

        if(type != null) {
            context.setType( type );
        }

        return context;
    }

    private void addShipmentLegTo(PretaxDelivery delivery) {

        shipment.ifPresent( es -> {
            ShipmentLeg shipmentLeg = new ShipmentLeg();
            delivery.setShipmentLeg(shipmentLeg);
            if (es.getShipFrom() != null) {
                shipmentLeg.setShipFromLocation(toPretaxLocation(es.getShipFrom()));
            }
            if (es.getShipTo() != null) {
                shipmentLeg.setShipToLocation(toPretaxLocation(es.getShipTo()));
            }
        });
    }

    public static final class Builder {

        private EnrichedTransactionContext instance;

        private Builder() {}

        public static Builder create() {
            Builder builder = new Builder();
            builder.instance = new EnrichedTransactionContext();
            return builder;
        }

        public Builder withSenderLocation( Location sender ) {
            this.instance.setSenderLocation(sender);
            return this;
        }

        public Builder withReceiverLocation( Location receiver ) {
            this.instance.setReceiverLocation(receiver);
            ;
            return this;
        }

        public Builder withDispatchDate( LocalDate dispatchDate ) {
            this.instance.setDispatchDate(dispatchDate);
            return this;
        }

        public Builder withDeliverDate( LocalDate deliverDate ) {
            this.instance.setDeliverDate(deliverDate);
            return this;
        }

        public Builder withServiceRenderedArea( Location serviceRenderedArea ) {
            this.instance.setServiceRenderedArea(serviceRenderedArea);
            return this;
        }

        public Builder withChainTransaction( ChainTransaction chainTransaction ) {
            this.instance.setChainTransaction(chainTransaction);
            return this;
        }

        public Builder withShipment( EnrichedShipment shipment ) {
            this.instance.setShipment(shipment);
            return this;
        }

        public Builder withServiceProviderLocation(Location serviceProviderLocation){
            this.instance.setServiceProviderLocation(serviceProviderLocation);
            return this;
        }

        public Builder withType(TransactionContext.TransactionContextType type) {
            this.instance.setType( type );
            return this;
        }

        public Builder intoBond(boolean intoBond) {
            this.instance.setIntoBond( intoBond );
            return this;
        }

        public Builder outOfBond(boolean outOfBond) {
            this.instance.setOutOfBond( outOfBond );
            return this;
        }

        public EnrichedTransactionContext build() {
            return instance;
        }
    }

}
