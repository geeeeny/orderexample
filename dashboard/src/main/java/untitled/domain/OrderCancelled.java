package untitled.domain;

import untitled.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class OrderCancelled extends AbstractEvent {

    private Long id;
}
