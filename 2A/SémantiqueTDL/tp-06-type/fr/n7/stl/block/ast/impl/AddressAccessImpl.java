/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.impl.PointerTypeImpl;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.block.ast.AtomicType;

/**
 * Implementation of the Abstract Syntax Tree node for accessing an address element.
 *
 */
public class AddressAccessImpl implements Expression {

	protected Expression address;

	public AddressAccessImpl(Expression _address) {
		this.address = _address;
	}

	@Override
	public String toString() {
		return ("&("+this.address+")");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		return new PointerTypeImpl(address.getType());	
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();

		fragment.append(address.getCode(_factory));

		return fragment;
	}

}
