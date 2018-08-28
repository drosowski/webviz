package com.intellivat.domain.invoice.taxationresult;

import com.google.common.base.Preconditions;
import com.intellivat.domain.Amount;

import java.util.Objects;

public class TotalCalculation {

    private final Amount baseTotal;
    private final Amount taxTotal;
    private final Amount total;

    public TotalCalculation(Amount baseTotal, Amount taxTotal, Amount total) {
        this.baseTotal = baseTotal;
        this.taxTotal = taxTotal;
        this.total = total;
    }

    public Amount getBaseTotal() {
        return baseTotal;
    }

    public Amount getTaxTotal() {
        return taxTotal;
    }

    public Amount getTotal() {
        return total;
    }

    public TotalCalculation add(TotalCalculation other){
        Preconditions.checkArgument(other != null);
        return new TotalCalculation(baseTotal.add(other.baseTotal),
                taxTotal.add(other.taxTotal),
                total.add(other.total));
    }

    @Override
    public String toString() {
        return "TotalCalculation{" +
                "baseTotal=" + baseTotal +
                ", taxTotal=" + taxTotal +
                ", total=" + total +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TotalCalculation that = (TotalCalculation) o;
        return Objects.equals(baseTotal, that.baseTotal) &&
                Objects.equals(taxTotal, that.taxTotal) &&
                Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseTotal, taxTotal, total);
    }
}
