package validation;

import com.sun.source.tree.PackageTree;
import com.sun.source.tree.ProvidesTree;
import vars.Defines;

import java.util.regex.Pattern;

public class PatternValidation extends Defines {
    protected static Pattern idPattern = Pattern.compile( "^[1-9]([0-9]{0,5})?$");
    protected static Pattern fullNamePattern = Pattern.compile("^([A-ZİŞÇÜÖ][a-zıöüşçğ]+)\\s([A-ZİŞÇÜÖ][a-zıöüşçğ]+)(\\s([A-ZİŞÇÜÖ][a-zıöüşçğ]+))*");
    protected static Pattern emailPattern = Pattern.compile("^([a-z]+[_ -.]?([0-9]+)?)+@([a-z]+[-]?([a-z]+)?)\\.[a-z]+(\\.[a-z]+)?");
    protected static Pattern intPattern = Pattern.compile("^[1-9][0-9]*$");
    protected static Pattern updateValuePattern = Pattern.compile("^(?:Tam ad|Email)$");
}
