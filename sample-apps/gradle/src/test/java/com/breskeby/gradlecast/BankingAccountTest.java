package com.breskeby.gradlecast;

import org.junit.Test;
import static org.junit.Assert.*;

public class BankingAccountTest{
	
	@Test public void newBankingAccountHasZeroBalance(){
		assertEquals(0.0, new BankingAccount().getBalance(), 0.0);
	}
}