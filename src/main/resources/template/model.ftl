@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ${model} extends BaseModel {
<#list properties?keys as key>
private ${properties[key]} ${key};
</#list>
}