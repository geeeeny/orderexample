package untitled.domain;

import untitled.domain.*;
import untitled.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class InventoryIncreased extends AbstractEvent {

    private Long id;

    public InventoryIncreased(Inventory aggregate){
        super(aggregate);
    }
    public InventoryIncreased(){
        super();
    }
}
