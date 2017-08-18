package org.spring.springboot.dto;

public abstract class TreeBaseDto extends BaseDto {

	private static final long serialVersionUID = 1311980587298856911L;
	
	/**
     * 资源名称
     */
	private String parentId;
	
	/**
     * 资源名称
     */
	private String parentName;
	
	/**
     * 是否叶子节点
     */
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
