package edu.fdu.se.mapper;

import edu.fdu.se.bean.AndroidPlatformFrameworkProject;
import edu.fdu.se.bean.AndroidPlatformFrameworkProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AndroidPlatformFrameworkProjectMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table android_platform_framework_project
	 * @mbg.generated  Sun Dec 17 20:41:24 CST 2017
	 */
	long countByExample(AndroidPlatformFrameworkProjectExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table android_platform_framework_project
	 * @mbg.generated  Sun Dec 17 20:41:24 CST 2017
	 */
	int deleteByExample(AndroidPlatformFrameworkProjectExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table android_platform_framework_project
	 * @mbg.generated  Sun Dec 17 20:41:24 CST 2017
	 */
	int insert(AndroidPlatformFrameworkProject record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table android_platform_framework_project
	 * @mbg.generated  Sun Dec 17 20:41:24 CST 2017
	 */
	int insertSelective(AndroidPlatformFrameworkProject record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table android_platform_framework_project
	 * @mbg.generated  Sun Dec 17 20:41:24 CST 2017
	 */
	List<AndroidPlatformFrameworkProject> selectByExample(AndroidPlatformFrameworkProjectExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table android_platform_framework_project
	 * @mbg.generated  Sun Dec 17 20:41:24 CST 2017
	 */
	int updateByExampleSelective(@Param("record") AndroidPlatformFrameworkProject record,
			@Param("example") AndroidPlatformFrameworkProjectExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table android_platform_framework_project
	 * @mbg.generated  Sun Dec 17 20:41:24 CST 2017
	 */
	int updateByExample(@Param("record") AndroidPlatformFrameworkProject record,
			@Param("example") AndroidPlatformFrameworkProjectExample example);

	List<AndroidPlatformFrameworkProject> selectAll();
}