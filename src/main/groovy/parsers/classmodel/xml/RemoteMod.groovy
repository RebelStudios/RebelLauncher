package parsers.classmodel.xml

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

/**
 * Created by misterti.me on 5/27/2014.
 *
 * Ported to Groovy by Kepler Sticka-Jones on 10/24/2014.
 */
@XmlRootElement(name = "mod")
@XmlAccessorType(XmlAccessType.FIELD)
class RemoteMod {
    @XmlElement(name = "name", required = true)
    String name

    @XmlElement(name = "file", required = true)
    String file

    @XmlElement(name = "SHA", required = true)
    String SHAHash

    @XmlElement(name = "modVersion", required = true)
    String modVersion

    @XmlElement(name = "MC", required = true)
    String MC

    @XmlElement(name = "forgeVersion", required = true)
    String forgeVersion

    @XmlElement(name = "branch", required = true)
    String branch

    @XmlElement(name = "type", required = true)
    String type
}
