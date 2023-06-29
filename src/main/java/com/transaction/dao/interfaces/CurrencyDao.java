package com.transaction.dao.interfaces;

import com.transaction.entity.Currency;

public interface CurrencyDao extends GenericOperation<Currency>{

     Currency getConversionPair(String firstCurrency, String secondCurrency);
}
