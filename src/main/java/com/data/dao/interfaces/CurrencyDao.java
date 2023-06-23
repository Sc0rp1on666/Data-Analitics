package com.data.dao.interfaces;

import com.data.entity.Currency;

public interface CurrencyDao extends GenericOperation<Currency>{

     Currency getConversionPair(String conversionPair);
}
