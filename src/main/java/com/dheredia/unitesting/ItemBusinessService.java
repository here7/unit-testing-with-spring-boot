package com.dheredia.unitesting;

import com.dheredia.unitesting.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemBusinessService {
    public Item retreiveHardcodedItem(){
        return new Item(1,"Ball", 10, 100);
    }
}
