
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;


public class Email {
    private String value;
    private AtibutoEmail type;

    public Email() {
    }

    public Email(String value, AtibutoEmail type) {
        this.value = value;
        this.type = type;
    }

    @XmlValue
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @XmlAttribute
    public AtibutoEmail getType() {
        return type;
    }

    public void setType(AtibutoEmail type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Email{" + "value=" + value + ", type=" + type + '}';
    }



}