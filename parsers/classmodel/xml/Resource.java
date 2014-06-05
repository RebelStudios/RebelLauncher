package parsers.classmodel.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by misterti.me on 5/27/2014.
 */
@XmlRootElement(name = "ListBucketResult")
@XmlAccessorType(XmlAccessType.FIELD)
public class Resource {
    @XmlElement(name = "Key")
    public String file;

    @XmlElement(name = "LastModified")
    public String lastModified;

    @XmlElement(name = "ETag")
    public String hash;

    @XmlElement(name = "Size")
    public int size;

    @XmlElement(name = "StorageClass")
    public String storageClass;

    @XmlElement(name = "Contents")
    public ArrayList<Resource> resources = null;

}
