package parsers.classmodel.xml;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

/**
 * Created by misterti.me on 5/26/2014.
 */
@XmlRootElement(name="mods")
@XmlAccessorType(XmlAccessType.FIELD)
public class Mod {
    @XmlElement(name="mod")
    public ArrayList<Mod> mods = new ArrayList();

    public ModType modType;

    @XmlAttribute(name = "xml")
    public String xml;

    @XmlAttribute(name = "url")
    public String url;

    @XmlAttribute(name = "permissions")
    public String permissions;

    @XmlAttribute(name = "type")
    public String type;

}
