package parsers.classmodel.xml

import javax.xml.bind.annotation.*

/**
 * Created by misterti.me on 5/26/2014.
 * 
 * Ported to Groovy by Kepler Sticka-Jones on 10/24/2014.
 */
@XmlRootElement(name="mods")
@XmlAccessorType(XmlAccessType.FIELD)
class Mod {
    @XmlElement(name="mod")
    ArrayList<Mod> mods = new ArrayList()

    ModType modType

    @XmlAttribute(name = "xml")
    String xml

    @XmlAttribute(name = "url")
    String url

    @XmlAttribute(name = "permissions")
    String permissions

    @XmlAttribute(name = "type")
    String type
}
