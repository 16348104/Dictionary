<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="${model?lower_case}">
    <insert id="add" parameterType="${model}" useGeneratedKeys="true" keyProperty="id">
        INSERT INTO ${db}.${table} (
    <#list columns?keys as key>
    ${key}<#if key_has_next>, </#if>
    </#list>
        )
        VALUES (
    <#list columns?keys as key>
    ${'#'}{${columns[key]}}<#if key_has_next>, </#if>
    </#list>
        );
    </insert>
    <delete id="remove">
        DELETE FROM ${db}.${table}
        WHERE id = ${'#'}{id}
    </delete>
    <update id="modify">
        UPDATE ${db}.${table}
        SET
    <#list columns?keys as key>
    ${key} = ${'#'}{${columns[key]}}<#if key_has_next>, </#if>
    </#list>
        WHERE id = ${'#'}{id}
    </update>
    <select id="list" resultType="${model?lower_case}">
        SELECT *
        FROM ${db}.${table}
        ORDER BY id
    </select>
    <select id="query" parameterType="${model?lower_case}" resultType="${model?lower_case}">
        SELECT *
        FROM ${db}.${table}
        <where>
            <if test="id != null and id != ''">
                id = ${'#'}{id}
            </if>
        <#list columns?keys as key>
            <if test="${key} != null and ${key} != ''"> AND ${key} LIKE "%"${'#'}{${columns[key]}}"%"</if>
        </#list>
        </where>
    </select>
    <select id="search" resultType="${model?lower_case}">
        SELECT *
        FROM ${db}.${table}
        WHERE id = ${'#'}{id}
    </select>
</mapper>