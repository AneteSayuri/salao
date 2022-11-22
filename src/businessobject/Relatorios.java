package businessobject;

import java.util.List;

public class Relatorios <T> {

    public void imprimirLista(List<T> lista){
        int count = 1;
        for (T t:lista){
            System.out.println(count +") "+ t);
            count++;
        }

    }


}
