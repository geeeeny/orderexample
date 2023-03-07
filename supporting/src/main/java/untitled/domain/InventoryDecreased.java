package untitled.domain;

import untitled.domain.*;
import untitled.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class InventoryDecreased extends AbstractEvent {

    private Long id;

    public InventoryDecreased(Inventory aggregate){
        super(aggregate);
    }
    public InventoryDecreased(){
        super();
    }
}
