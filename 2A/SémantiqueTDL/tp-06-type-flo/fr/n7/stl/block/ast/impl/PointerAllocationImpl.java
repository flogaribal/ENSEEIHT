package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.TAMFactory;



public class PointerAllocationImpl implements Expression {

    private Type type;

    public PointerAllocationImpl(Type _type) {
        this.type = _type;
    }

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.Expression#getType()
     */
    @Override
    public Type getType() {
        return new PointerTypeImpl(this.type);
    }

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.Expression#getCode()
     */
    @Override
    public Fragment getCode(TAMFactory _factory) {
        Fragment fragment = _factory.createFragment();

        fragment.add(_factory.createLoadL(type.length()));
        fragment.add(Library.MAlloc);

        return fragment;
    }
}