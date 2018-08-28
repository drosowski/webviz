<table border="0" cellborder="1" cellspacing="0" cellpadding="2">
    <tr>
        <td>Tax Indicator:</td>
        <td>${taxIndicator!"_NA_"}</td>
    </tr>
    <tr>
        <td>Seller Jurisdiction Reference:</td>
        <td>${sellerGeoArea!"_NA_"}</td>
    </tr>
    <tr>
        <td>Buyer Jurisdiction Reference:</td>
        <td>${buyerGeoArea!"_NA_"}</td>
    </tr>
    <tr>
        <td>Seller Tax Registration:</td>
        <td>${sellerTaxReg!"not required"}</td>
    </tr>
    <tr>
        <td>Buyer Tax Registration:</td>
        <td>${buyerTaxReg!"not required"}</td>
    </tr>
<#if additionalTaxIndicator??>
    <tr>
        <td align="center" colspan="3">
            <hr/>
        </td>
    </tr>
    <tr>
        <td>Tax Indicator:</td>
        <td>${additionalTaxIndicator!"_NA_"}</td>
    </tr>
    <tr>
        <td>Seller Jurisdiction Reference:</td>
        <td>${additionalSellerGeoArea!"_NA_"}</td>
    </tr>
    <tr>
        <td>Buyer Jurisdiction Reference:</td>
        <td>${additionalBuyerGeoArea!"_NA_"}</td>
    </tr>
    <tr>
        <td>Seller Tax Registration:</td>
        <td>${additionalSellerTaxReg!"not required"}</td>
    </tr>
    <tr>
        <td>Buyer Tax Registration:</td>
        <td>${additionalBuyerTaxReg!"not required"}</td>
    </tr>
</#if>
</table>