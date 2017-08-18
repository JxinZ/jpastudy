package org.spring.springboot.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@MappedSuperclass
@JsonIgnoreType
public abstract class BaseEntity implements Identifiable {
	public final static Boolean DELETED = true;

	private static final long serialVersionUID = 3961004285380928190L;
	@Id
	@Column(length=32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	@Version
	protected Integer version;
	/**
	 * 记录是否逻辑删除 。true 已删除，false 未删除
	 */
	@Column(name="is_deleted")
	Boolean isDeleted = false;
	/**
	 * 新增时间
	 */
	@Column(name="create_time")
	private Date createTime;
	/**
	 * 修改时间
	 */
	@Column(name="update_time")
	private Date updateTime;
	/**
	 * 删除时间
	 */
	@Column(name="delete_time")
	private Date deleteTime;
	/**
	 * 创建人
	 */
	@Column(length = 32,name="create_by")
	private String createBy;
	/**
	 * 修改人
	 */
	@Column(length = 32,name="update_by")
	private String updateBy;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime
	 *            the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return the deleteTime
	 */
	public Date getDeleteTime() {
		return deleteTime;
	}

	/**
	 * @param deleteTime
	 *            the deleteTime to set
	 */
	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}


	public <D, T> D toDto(T entity,D dto) {
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
