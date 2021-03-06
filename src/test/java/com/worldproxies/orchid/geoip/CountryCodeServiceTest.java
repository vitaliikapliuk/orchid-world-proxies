package com.worldproxies.orchid.geoip;

import com.worldproxies.orchid.data.IPv4Address;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class CountryCodeServiceTest {

	private CountryCodeService ccs;
	
	@Before
	public void before() {
		ccs = CountryCodeService.getInstance();
	}
		
	@Test
	public void test() throws IOException {
		testAddress("FR", "217.70.184.1");     // www.gandi.net
		testAddress("DE", "213.165.65.50");    // www.gmx.de
		testAddress("AR", "200.42.136.212");   // www.clarin.com
		testAddress("GB", "77.91.248.30");	   // www.guardian.co.uk
		testAddress("CA", "132.216.177.160");  // www.mcgill.ca
		testAddress("US", "38.229.72.14");     // www.torproject.net
	}

	private void testAddress(String expectedCC, String address) {
		IPv4Address a = IPv4Address.createFromString(address);
		String cc = ccs.getCountryCodeForAddress(a);
		assertEquals("Country Code lookup for "+ address, expectedCC, cc);
	}
}
