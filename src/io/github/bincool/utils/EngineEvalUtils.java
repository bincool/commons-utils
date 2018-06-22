/**
* @FileName: EngineEvalUtils.java
* @Package: io.github.bincool.utils
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: EngineEvalUtils.java: 智能算法，Js引擎执行计算表达式.
* @Author wchy，技术交流(891946049).
* @Date 2018年6月12日 下午10:00:56.
* @Content: 新增.
* @Version: V1.0.
*/
package io.github.bincool.utils;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import io.github.bincool.utils.commons.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @ClassName: EngineEvalUtils.java
* 
* @Description: 
* <p>
* 智能算法，Js引擎执行计算表达式.
* </p>
* <p>
* 详细描述:智能算法，Js引擎执行计算表达式.
* </p>
* <p>
* 示例代码.
* // 1 参数准备.
* Map<String, Object> params = new HashMap<String, Object>();
* params.put("长", 5);
* params.put("高", 3);
*
* // 2 表达式准备：可通过数据查询或自主构造，其中return的表达式后需用英文逗号结束(用于匹配具体计算过程).
* // return主要用于if条件分支和function函数之中，当只有一个表达式(没有分支判断也不是函数)时直接书写一行表达式即可毋须添加结束符.
* // formula = "if([长]>300){return 5;}else{return 6;}";
* // formula = "function cal() { return 100;}";
* String formula = "[长]*[宽]";
*
* // 3.1 智能计算结果.
* Object calResult = EngineEvalUtils.smartCal(formula, params);
* System.out.println(calResult);
*
*
* // 3.2 智能获取表达式计算过程.
* Object formulaResult = EngineEvalUtils.smartFormula(formula, params);
* System.out.println(formulaResult);
* </p>
*
* @Author: wchy，技术交流(891946049).
* 
* @Date: 2018年6月12日 下午10:00:56.
* 
*/
public class EngineEvalUtils 
{
	
    /**
     * 正则表达式匹配用户输入的函数名和参数.
     */
    private static final Pattern patternFuncName = Pattern.compile("function([^\\{]*)\\{");

    /**
     * 正则表达式匹配用户输入的函数名和参数.
     */
    private static final Pattern patternFormula = Pattern.compile("return([^;]*);");

    /**
     * 智能算法，Js引擎执行计算表达式.
     * @param formula
     * @param params
     * @return
     * @throws Exception
     */
    public static Object smartCal(String formula, Map<String, Object> params) throws Exception
    {
        // 智能算法执行结果.
        Object calResult = null;

        // 表达式检测.
        if (StringUtils.isEmpty(formula))
        {
            throw new IllegalArgumentException("表达式不合法，formula = " + formula);
        }

        // 表达式处理.
        formula = formula.trim().replaceAll("\\[", "").replaceAll("\\]", "");

        // JavaScript脚本引擎.
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        // 算法所需参数变量赋值-全局变量声明赋值.
        if (null != params)
        {
            for(Map.Entry<String,Object> entry : params.entrySet())
            {
                 if (null != entry.getValue())
                 {
                     engine.put(entry.getKey(), new BigDecimal(entry.getValue().toString()));
                 }
                 else
                 {
                     engine.put(entry.getKey(), 0);
                 }
            }
        }

        // Js函数执行.
        Invocable invocable = null;
        if (formula.contains("function"))
        {
            Matcher matcher = patternFuncName.matcher(formula);
            if (matcher.find())
            {
                formula = formula.replace(matcher.group(1), " smartCal() ");
                engine.eval(formula);
                invocable = (Invocable) engine;
                calResult = invocable.invokeFunction("smartCal", new Object());
            }
            else
            {
                throw new IllegalArgumentException("表达式不合法，formula = " + formula);
            }
        }
        // 包装到js函数体中执行.
        else if (formula.contains("if") || formula.contains("return"))
        {
            formula = "function smartCal() {formula}".replace("formula", formula);
            engine.eval(formula);
            invocable = (Invocable) engine;
            calResult = invocable.invokeFunction("smartCal", new Object());
        }
        // 直接执行表达式.
        else
        {
            calResult = engine.eval(formula);
        }

        return calResult;
    }

    /**
     * 智能算法，Js引擎返回计算表达式(无变量([variableName])公式).
     * @param formula
     *      计算表达式，可以含function,if,return等关键字.
     * @param params
     * @return
     * @throws Exception
     */
    public static Object smartFormula(String formula, Map<String, Object> params) throws Exception
    {
        // 智能算法执行结果.
        Object formulaResult = null;

        // 表达式检测.
        if (StringUtils.isEmpty(formula))
        {
            throw new IllegalArgumentException("表达式公式不合法，formula = " + formula);
        }

        // 表达式处理.
        formula = formula.trim();

        // 有return关键字，则提取return与结束符(;)之间的计算表达式.
        if (formula.contains("return"))
        {
            // 表达式检查.
            if (!formula.contains(";"))
            {
                throw new IllegalArgumentException("表达式公式不合法，formula = " + formula);
            }

            // 正则匹配有哪几种表达式.
            List<String> formulaList = new ArrayList<String>();
            Matcher matcher = patternFormula.matcher(formula);
            while (matcher.find())
            {
                formulaList.add(matcher.group(1));
            }

            // 对表达式进行计算对比，确定具体所用的表达式，并对变量用真实数值进行替换.
            try
            {
                Number smartCalResult = (Number)smartCal(formula, params);

                for (String tmpFormula : formulaList)
                {
                    Number tmp = (Number)smartCal(tmpFormula, params);
                    if (smartCalResult.doubleValue() == tmp.doubleValue())
                    {
                        formulaResult = formula(tmpFormula, params);
                        break;
                    }
                }

                if (null == formulaResult)
                {
                    throw new IllegalArgumentException("表达式公式不合法，formula = " + formula);
                }
            }
            catch (Exception e)
            {
                throw new IllegalArgumentException("表达式公式不合法，formula = " + formula);
            }
        }
        else
        {
            formulaResult = formula(formula, params);
        }

        return formulaResult;
    }

    /**
     * 智能算法，Js引擎返回计算表达式(无变量([variableName])公式).
     * @param formula
     *      计算表达式，不含function,if,return.
     * @param params
     * @return
     * @throws Exception
     */
    public static Object formula(String formula, Map<String, Object> params) throws Exception
    {
        // 智能算法执行结果.
        Object formulaResult = null;

        // 表达式检测.
        if (StringUtils.isEmpty(formula) || formula.contains("if") || formula.contains("return") || formula.contains("function"))
        {
            throw new IllegalArgumentException("表达式公式不合法，formula = " + formula);
        }

        // 表达式处理.
        formula = formula.trim();

        // 变量检查，有变量则替换变量为真实计算数值.
        if (formula.contains("[") && formula.contains("]"))
        {
            formula = "'formula'".replace("formula", formula.trim());
            formula = formula.replaceAll("\\[", "'+").replaceAll("\\]", "+'");
            formulaResult = smartCal(formula, params);
        }
        else
        {
            formulaResult = formula;
        }

        return formulaResult;
    }
	
}
