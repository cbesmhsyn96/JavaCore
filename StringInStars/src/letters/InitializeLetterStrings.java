package letters;


import com.sun.source.tree.BreakTree;

import java.util.HashMap;

public class InitializeLetterStrings extends Defines{
    protected static HashMap<Character,String[]> initializeString(){
        stars.put('a', a);
        stars.put('b', b);
        stars.put('c', c);
        stars.put('d', d);
        stars.put('e', e);
        stars.put('f', f);
        stars.put('g', g);
        stars.put('h', h);
        stars.put('ı', i);
        stars.put('j', j);
        stars.put('k', k);
        stars.put('l', l);
        stars.put('m', m);
        stars.put('n', n);
        stars.put('o', o);
        stars.put('p', p);
        stars.put('q', q);
        stars.put('r', r);
        stars.put('s', s);
        stars.put('t', t);
        stars.put('u', u);
        stars.put('v', v);
        stars.put('w', w);
        stars.put('x', x);
        stars.put('y', y);
        stars.put('z', z);
        stars.put('ç', che);
        stars.put('ğ', softG);
        stars.put('ş', she);
        stars.put('ö', oLetter);
        stars.put('ü', uLetter);
        stars.put('i', iLetter);
        stars.put(' ',whiteSpace);
        return stars;
    }
}
