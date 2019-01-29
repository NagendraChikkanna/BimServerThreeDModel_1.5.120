/**
 * Copyright (C) 2009-2014 BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc4.impl;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcRelSpaceBoundary1stLevel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Space Boundary1st Level</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelSpaceBoundary1stLevelImpl#getParentBoundary <em>Parent Boundary</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelSpaceBoundary1stLevelImpl#getInnerBoundaries <em>Inner Boundaries</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRelSpaceBoundary1stLevelImpl extends IfcRelSpaceBoundaryImpl implements IfcRelSpaceBoundary1stLevel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelSpaceBoundary1stLevelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY1ST_LEVEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelSpaceBoundary1stLevel getParentBoundary() {
		return (IfcRelSpaceBoundary1stLevel) eGet(Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY1ST_LEVEL__PARENT_BOUNDARY,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentBoundary(IfcRelSpaceBoundary1stLevel newParentBoundary) {
		eSet(Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY1ST_LEVEL__PARENT_BOUNDARY, newParentBoundary);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetParentBoundary() {
		eUnset(Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY1ST_LEVEL__PARENT_BOUNDARY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetParentBoundary() {
		return eIsSet(Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY1ST_LEVEL__PARENT_BOUNDARY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelSpaceBoundary1stLevel> getInnerBoundaries() {
		return (EList<IfcRelSpaceBoundary1stLevel>) eGet(
				Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY1ST_LEVEL__INNER_BOUNDARIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetInnerBoundaries() {
		eUnset(Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY1ST_LEVEL__INNER_BOUNDARIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetInnerBoundaries() {
		return eIsSet(Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY1ST_LEVEL__INNER_BOUNDARIES);
	}

} //IfcRelSpaceBoundary1stLevelImpl