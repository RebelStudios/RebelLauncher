package parsers.classmodel.xml

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement
import java.util.ArrayList

/**
 * Created by misterti.me on 5/27/2014.
 *
 * Ported to Groovy by Kepler Sticka-Jones on 10/24/2014.
 */
@XmlRootElement(name = "ListBucketResult")
@XmlAccessorType(XmlAccessType.FIELD)
class Resource {
    @XmlElement(name = "Key")
    String file

    @XmlElement(name = "LastModified")
    String lastModified

    @XmlElement(name = "ETag")
    String hash

    @XmlElement(name = "Size")
    int size

    @XmlElement(name = "StorageClass")
    String storageClass

    @XmlElement(name = "Contents")
    ArrayList<Resource> resources = null

}
