package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for accessing an array allocation.
 *
 */
public class ArrayAllocationImpl implements Expression {

    private Type type;
    private Expression size;

    public ArrayAllocationImpl(Type _type, Expression _size) {
        this.type = _type;
        this.size = _size;
    }


    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.Expression#getType()
     */
    @Override
    public Type getType() {
        return new ArrayTypeImpl(this.type);
    }

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
     */
    @Override
    public Fragment getCode(TAMFactory _factory) {
        Fragment fragment = _factory.createFragment();

        fragment.add(_factory.createLoadL(type.length()));
        fragment.append(size.getCode(_factory));
        fragment.add(Library.IMul);
        fragment.add(Library.MAlloc);

        return fragment;
    }

    @Override
    public String toString() {
        return ("new " + this.type.toString() + "[ " + this.size.toString() + " ]");
    }

}