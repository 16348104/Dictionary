package <#if package!="">${package}.</#if>model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ${model} extends BaseModel {

    private ${PK} id;
    <#list properties?keys as key>
    private ${properties[key]} ${key};
    </#list>
}