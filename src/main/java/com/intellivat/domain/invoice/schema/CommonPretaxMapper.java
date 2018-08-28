package com.intellivat.domain.invoice.schema;

import com.google.common.base.Strings;
import com.intellivat.domain.masterdata.Company;
import com.intellivat.domain.masterdata.Location;
import com.intellivat.domain.masterdata.LocationLevel;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.Instant;
import java.time.ZoneId;
import java.util.GregorianCalendar;

//TODO: Refactor to a better place
public class CommonPretaxMapper {

    private static final String LOCATION_SEPARATOR = "-";

    public static PretaxLocation toPretaxLocation(Location location){
        PretaxLocation pretaxLocation = new PretaxLocation();
        if (location.getLevel() == LocationLevel.COUNTRY) {
            pretaxLocation.setCountryCode(location.getKey());
        } else {
            String country = location.getParent().get().getKey();
            String state = location.getKey().replaceFirst( country + LOCATION_SEPARATOR, "" );
            pretaxLocation.setCountryCode( country );
            pretaxLocation.setStateCode( state );
        }
        return pretaxLocation;
    }

    public static PretaxDelivery toPretaxDelivery(Location senderLocation, Location receiverLocation,
                                                  Location shipFromLocation, Location shipToLocation){
        PretaxDelivery delivery = new PretaxDelivery();
        delivery.setSenderLocation(toPretaxLocation(senderLocation));
        delivery.setReceiverLocation(toPretaxLocation(receiverLocation));
        if (shipFromLocation != null && shipToLocation != null){
            ShipmentLeg shipmentLeg = new ShipmentLeg();
            shipmentLeg.setShipFromLocation(toPretaxLocation(shipFromLocation));
            shipmentLeg.setShipToLocation( toPretaxLocation( shipToLocation ) );
            delivery.setShipmentLeg( shipmentLeg );
        }
        return delivery;
    }

    public static CompanyRef toPretaxCompanyRef(Company company){
        CompanyRef companyRef = new CompanyRef();
        companyRef.setCompanyId( company.getCustomId() );
        return companyRef;
    }


    public static Location toLocation(PretaxLocation location){
        if (Strings.isNullOrEmpty(location.getStateCode())){
            return new Location(location.getCountryCode());
        } else {
            String stateKey = location.getCountryCode() + LOCATION_SEPARATOR + location.getStateCode();
            return Location.createState(stateKey, location.getCountryCode());
        }
    }

    public static Instant toInstant( XMLGregorianCalendar calendar ) {
        return calendar.toGregorianCalendar().toInstant();
    }

    public static XMLGregorianCalendar toXmlTimeStamp(Instant timestamp){
        GregorianCalendar gcal = GregorianCalendar.from(timestamp.atZone(ZoneId.systemDefault()));
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
        } catch (DatatypeConfigurationException e) {
            return null;
        }
    }
}
