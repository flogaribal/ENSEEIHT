/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Type;

import fr.n7.stl.block.ast.AtomicType;	

/**
 * Implementation of the Abstract Syntax Tree node for a pointer type.
 * @author Marc Pantel
 *
 */
public class PointerTypeImpl implements Type {

	private Type element;

	public PointerTypeImpl(Type _element) {
		this.element = _element;
	}
	
	public Type getPointedType() {
		return this.element;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#equalsTo(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean equalsTo(Type _other) {
		//throw new SemanticsUndefinedException("Semantics equalsTo undefined in PointerTypeImpl.");
		if (_other instanceof PointerTypeImpl) {
			return element.equalsTo(((PointerTypeImpl)_other).getPointedType());	
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#compatibleWith(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean compatibleWith(Type _other) {
		//throw new SemanticsUndefinedException("Semantics compatibleWith undefined in PointerTypeImpl.");
		if (_other instanceof PointerTypeImpl) {
			return element.compatibleWith(((PointerTypeImpl)_other).getPointedType());	
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#merge(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type merge(Type _other) {	
		//throw new SemanticsUndefinedException("Semantics merge undefined in PointerTypeImpl.");
		if (element.compatibleWith(_other)) {
			return element.merge(_other);
		}
		return AtomicType.ErrorType;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#length(int)
	 */
	@Override
	public int length() {
		return 1;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + this.element + " *)";
	}
}
