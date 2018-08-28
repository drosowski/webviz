
package com.intellivat.domain.invoice.schema;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.intellivat.domain.invoice.schema package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UnspscCode_QNAME = new QName("http://intellivat.com/invoice", "unspscCode");
    private final static QName _UnitPrice_QNAME = new QName("http://intellivat.com/invoice", "unitPrice");
    private final static QName _Quantity_QNAME = new QName("http://intellivat.com/invoice", "quantity");
    private final static QName _CommunicationLanguage_QNAME = new QName("http://intellivat.com/invoice", "communicationLanguage");
    private final static QName _ReferenceTimestamp_QNAME = new QName("http://intellivat.com/invoice", "referenceTimestamp");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.intellivat.domain.invoice.schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TransactionContext }
     * 
     */
    public TransactionContext createTransactionContext() {
        return new TransactionContext();
    }

    /**
     * Create an instance of {@link PriceInfo }
     * 
     */
    public PriceInfo createPriceInfo() {
        return new PriceInfo();
    }

    /**
     * Create an instance of {@link OutputInvoiceLine }
     * 
     */
    public OutputInvoiceLine createOutputInvoiceLine() {
        return new OutputInvoiceLine();
    }

    /**
     * Create an instance of {@link OutputTaxIndicatorComments }
     * 
     */
    public OutputTaxIndicatorComments createOutputTaxIndicatorComments() {
        return new OutputTaxIndicatorComments();
    }

    /**
     * Create an instance of {@link InvoiceLineCalculationWrapper }
     * 
     */
    public InvoiceLineCalculationWrapper createInvoiceLineCalculationWrapper() {
        return new InvoiceLineCalculationWrapper();
    }

    /**
     * Create an instance of {@link Invoicing }
     * 
     */
    public Invoicing createInvoicing() {
        return new Invoicing();
    }

    /**
     * Create an instance of {@link Invoicing.Totals }
     * 
     */
    public Invoicing.Totals createInvoicingTotals() {
        return new Invoicing.Totals();
    }

    /**
     * Create an instance of {@link OutputPostTaxInvoice }
     * 
     */
    public OutputPostTaxInvoice createOutputPostTaxInvoice() {
        return new OutputPostTaxInvoice();
    }

    /**
     * Create an instance of {@link OutputPostTaxInvoice.Info }
     * 
     */
    public OutputPostTaxInvoice.Info createOutputPostTaxInvoiceInfo() {
        return new OutputPostTaxInvoice.Info();
    }

    /**
     * Create an instance of {@link OutputPostTaxInvoice.Info.TaxDecisions }
     * 
     */
    public OutputPostTaxInvoice.Info.TaxDecisions createOutputPostTaxInvoiceInfoTaxDecisions() {
        return new OutputPostTaxInvoice.Info.TaxDecisions();
    }

    /**
     * Create an instance of {@link OutputTaxationResult }
     * 
     */
    public OutputTaxationResult createOutputTaxationResult() {
        return new OutputTaxationResult();
    }

    /**
     * Create an instance of {@link OutputTaxationResult.ProcessingInfo }
     * 
     */
    public OutputTaxationResult.ProcessingInfo createOutputTaxationResultProcessingInfo() {
        return new OutputTaxationResult.ProcessingInfo();
    }

    /**
     * Create an instance of {@link PreTaxInvoice }
     * 
     */
    public PreTaxInvoice createPreTaxInvoice() {
        return new PreTaxInvoice();
    }

    /**
     * Create an instance of {@link MetaParamValues }
     * 
     */
    public MetaParamValues createMetaParamValues() {
        return new MetaParamValues();
    }

    /**
     * Create an instance of {@link PretaxDocumentInfo }
     * 
     */
    public PretaxDocumentInfo createPretaxDocumentInfo() {
        return new PretaxDocumentInfo();
    }

    /**
     * Create an instance of {@link PretaxHeader }
     * 
     */
    public PretaxHeader createPretaxHeader() {
        return new PretaxHeader();
    }

    /**
     * Create an instance of {@link MainLines }
     * 
     */
    public MainLines createMainLines() {
        return new MainLines();
    }

    /**
     * Create an instance of {@link MainLine }
     * 
     */
    public MainLine createMainLine() {
        return new MainLine();
    }

    /**
     * Create an instance of {@link PretaxChainTransaction }
     * 
     */
    public PretaxChainTransaction createPretaxChainTransaction() {
        return new PretaxChainTransaction();
    }

    /**
     * Create an instance of {@link PretaxDelivery }
     * 
     */
    public PretaxDelivery createPretaxDelivery() {
        return new PretaxDelivery();
    }

    /**
     * Create an instance of {@link Service }
     * 
     */
    public Service createService() {
        return new Service();
    }

    /**
     * Create an instance of {@link PretaxLocation }
     * 
     */
    public PretaxLocation createPretaxLocation() {
        return new PretaxLocation();
    }

    /**
     * Create an instance of {@link AncillaryLines }
     * 
     */
    public AncillaryLines createAncillaryLines() {
        return new AncillaryLines();
    }

    /**
     * Create an instance of {@link AncillaryLine }
     * 
     */
    public AncillaryLine createAncillaryLine() {
        return new AncillaryLine();
    }

    /**
     * Create an instance of {@link ShipmentLeg }
     * 
     */
    public ShipmentLeg createShipmentLeg() {
        return new ShipmentLeg();
    }

    /**
     * Create an instance of {@link Entry }
     * 
     */
    public Entry createEntry() {
        return new Entry();
    }

    /**
     * Create an instance of {@link com.intellivat.domain.invoice.schema.TaxRegistrations }
     * 
     */
    public com.intellivat.domain.invoice.schema.TaxRegistrations createTaxRegistrations() {
        return new com.intellivat.domain.invoice.schema.TaxRegistrations();
    }

    /**
     * Create an instance of {@link TaxRegistration }
     * 
     */
    public TaxRegistration createTaxRegistration() {
        return new TaxRegistration();
    }

    /**
     * Create an instance of {@link PretaxCompany }
     * 
     */
    public PretaxCompany createPretaxCompany() {
        return new PretaxCompany();
    }

    /**
     * Create an instance of {@link CompanyRef }
     * 
     */
    public CompanyRef createCompanyRef() {
        return new CompanyRef();
    }

    /**
     * Create an instance of {@link OutputTotalCalculation }
     * 
     */
    public OutputTotalCalculation createOutputTotalCalculation() {
        return new OutputTotalCalculation();
    }

    /**
     * Create an instance of {@link OutputTaxCalculation }
     * 
     */
    public OutputTaxCalculation createOutputTaxCalculation() {
        return new OutputTaxCalculation();
    }

    /**
     * Create an instance of {@link TaxRateCalculation }
     * 
     */
    public TaxRateCalculation createTaxRateCalculation() {
        return new TaxRateCalculation();
    }

    /**
     * Create an instance of {@link OutputTaxIndicatorComments.TaxIndicatorComment }
     * 
     */
    public OutputTaxIndicatorComments.TaxIndicatorComment createOutputTaxIndicatorCommentsTaxIndicatorComment() {
        return new OutputTaxIndicatorComments.TaxIndicatorComment();
    }

    /**
     * Create an instance of {@link InvoiceLineCalculationWrapper.SplitCalculation }
     * 
     */
    public InvoiceLineCalculationWrapper.SplitCalculation createInvoiceLineCalculationWrapperSplitCalculation() {
        return new InvoiceLineCalculationWrapper.SplitCalculation();
    }

    /**
     * Create an instance of {@link Invoicing.InvoiceLines }
     * 
     */
    public Invoicing.InvoiceLines createInvoicingInvoiceLines() {
        return new Invoicing.InvoiceLines();
    }

    /**
     * Create an instance of {@link Invoicing.TaxRegistrations }
     * 
     */
    public Invoicing.TaxRegistrations createInvoicingTaxRegistrations() {
        return new Invoicing.TaxRegistrations();
    }

    /**
     * Create an instance of {@link Invoicing.Totals.TaxTypeTotals }
     * 
     */
    public Invoicing.Totals.TaxTypeTotals createInvoicingTotalsTaxTypeTotals() {
        return new Invoicing.Totals.TaxTypeTotals();
    }

    /**
     * Create an instance of {@link Invoicing.Totals.InvoiceTaxTotalInLocalCurrency }
     * 
     */
    public Invoicing.Totals.InvoiceTaxTotalInLocalCurrency createInvoicingTotalsInvoiceTaxTotalInLocalCurrency() {
        return new Invoicing.Totals.InvoiceTaxTotalInLocalCurrency();
    }

    /**
     * Create an instance of {@link OutputPostTaxInvoice.Info.TaxDecisions.TaxDecision }
     * 
     */
    public OutputPostTaxInvoice.Info.TaxDecisions.TaxDecision createOutputPostTaxInvoiceInfoTaxDecisionsTaxDecision() {
        return new OutputPostTaxInvoice.Info.TaxDecisions.TaxDecision();
    }

    /**
     * Create an instance of {@link OutputTaxationResult.PostTaxInvoices }
     * 
     */
    public OutputTaxationResult.PostTaxInvoices createOutputTaxationResultPostTaxInvoices() {
        return new OutputTaxationResult.PostTaxInvoices();
    }

    /**
     * Create an instance of {@link OutputTaxationResult.ProcessingInfo.Message }
     * 
     */
    public OutputTaxationResult.ProcessingInfo.Message createOutputTaxationResultProcessingInfoMessage() {
        return new OutputTaxationResult.ProcessingInfo.Message();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://intellivat.com/invoice", name = "unspscCode")
    public JAXBElement<String> createUnspscCode(String value) {
        return new JAXBElement<String>(_UnspscCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://intellivat.com/invoice", name = "unitPrice")
    public JAXBElement<BigDecimal> createUnitPrice(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_UnitPrice_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://intellivat.com/invoice", name = "quantity")
    public JAXBElement<BigDecimal> createQuantity(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Quantity_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://intellivat.com/invoice", name = "communicationLanguage")
    public JAXBElement<String> createCommunicationLanguage(String value) {
        return new JAXBElement<String>(_CommunicationLanguage_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://intellivat.com/invoice", name = "referenceTimestamp")
    public JAXBElement<XMLGregorianCalendar> createReferenceTimestamp(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ReferenceTimestamp_QNAME, XMLGregorianCalendar.class, null, value);
    }

}
