//package com.basharin.idgenerators;
//
//import java.io.Serializable;
//
//import org.hibernate.HibernateException;
//import org.hibernate.engine.spi.SharedSessionContractImplementor;
//import org.hibernate.id.IdentifierGenerator;
//
//
//public class CustomerIdGenerator implements IdentifierGenerator {
//	
//	@Override
//	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
//		
//		CustomerDto customerDto = new CustomerDto();
//		
//		String initials = customerDto.getFirstName().charAt(0).toUpperCase().concat(customerDto.getLastName().charAt(0).toUpperCse());
//		return null;
//	}
//}