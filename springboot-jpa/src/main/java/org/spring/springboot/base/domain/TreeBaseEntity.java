package org.spring.springboot.base.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class TreeBaseEntity extends BaseEntity {

	private static final long serialVersionUID = 1311980587298856911L;
	
	/**
     * 资源名称
     */
	@Column(name="parent_id",length=32)
	private String parentId;
	
	/**
     * 资源名称
     */
	@Column(name="parent_name",length=64)
	private String parentName;
	
	/**
     * 是否叶子节点
     */
	@Column(name="is_leaf")
	private Boolean isLeaf=Boolean.TRUE;

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Boolean getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	@Override
	public String toString() {
		return "TreeBaseEntity [parentId=" + parentId + ", parentName=" + parentName + ", isLeaf=" + isLeaf + "]";
	}
}
