package centralObject;

import java.util.Map;

public interface L<E> {
     public void setName(String name);
     public String getName();
     public Map<E,String> getRelation();
     public void setRelation(Map<E,String> relation);
}
