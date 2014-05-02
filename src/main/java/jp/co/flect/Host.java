package jp.co.flect;

import static javax.xml.bind.annotation.XmlAccessType.FIELD;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(FIELD)
@XmlType(propOrder = {"name", "address"})
public class Host {
	@XmlElement
	private String name;
	@XmlElement
	private String address;

	public Host() {}

	public Host(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }
}
