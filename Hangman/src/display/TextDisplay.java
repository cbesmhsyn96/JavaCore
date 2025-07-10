package display;

import input.InputManager;
import util.GamePreparer;

import java.util.Collections;
import java.util.List;

public class TextDisplay extends GamePreparer {

    // list the positions of the hidden characters in the word
    protected static void gizlikarakterleriListele(){
        System.out.println("                                       Positions of characters that can be guessed:");
        List<Integer> randPoints = getRandomIndexList();
        Collections.sort(randPoints);
        for (int letterPoint : randPoints){
            if(randPoints.size()>1){
                if(randPoints.getFirst() == letterPoint){
                    System.out.print("                                       << "+(letterPoint+1)+". character");
                } else if (letterPoint != randPoints.getLast()) {
                    System.out.print(","+(letterPoint+1)+". character");
                }else{
                    System.out.println(","+(letterPoint+1)+". character >>");
                }
            }
            if(randPoints.size()==1){
                System.out.println("                                       <<"+(letterPoint+1)+". character>>");
            }

        }
    }

}
