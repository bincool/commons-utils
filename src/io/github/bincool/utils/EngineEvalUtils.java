/**
* @FileName: EngineEvalUtils.java
* @Package: io.github.bincool.utils
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: EngineEvalUtils.java: �����㷨��Js����ִ�м�����ʽ.
* @Author wchy����������(891946049).
* @Date 2018��6��12�� ����10:00:56.
* @Content: ����.
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
* �����㷨��Js����ִ�м�����ʽ.
* </p>
* <p>
* ��ϸ����:�����㷨��Js����ִ�м�����ʽ.
* </p>
* <p>
* ʾ������.
* // 1 ����׼��.
* Map<String, Object> params = new HashMap<String, Object>();
* params.put("��", 5);
* params.put("��", 3);
*
* // 2 ���ʽ׼������ͨ�����ݲ�ѯ���������죬����return�ı��ʽ������Ӣ�Ķ��Ž���(����ƥ�����������).
* // return��Ҫ����if������֧��function����֮�У���ֻ��һ�����ʽ(û�з�֧�ж�Ҳ���Ǻ���)ʱֱ����дһ�б��ʽ����������ӽ�����.
* // formula = "if([��]>300){return 5;}else{return 6;}";
* // formula = "function cal() { return 100;}";
* String formula = "[��]*[��]";
*
* // 3.1 ���ܼ�����.
* Object calResult = EngineEvalUtils.smartCal(formula, params);
* System.out.println(calResult);
*
*
* // 3.2 ���ܻ�ȡ���ʽ�������.
* Object formulaResult = EngineEvalUtils.smartFormula(formula, params);
* System.out.println(formulaResult);
* </p>
*
* @Author: wchy����������(891946049).
* 
* @Date: 2018��6��12�� ����10:00:56.
* 
*/
public class EngineEvalUtils 
{
	
    /**
     * ������ʽƥ���û�����ĺ������Ͳ���.
     */
    private static final Pattern patternFuncName = Pattern.compile("function([^\\{]*)\\{");

    /**
     * ������ʽƥ���û�����ĺ������Ͳ���.
     */
    private static final Pattern patternFormula = Pattern.compile("return([^;]*);");

    /**
     * �����㷨��Js����ִ�м�����ʽ.
     * @param formula
     * @param params
     * @return
     * @throws Exception
     */
    public static Object smartCal(String formula, Map<String, Object> params) throws Exception
    {
        // �����㷨ִ�н��.
        Object calResult = null;

        // ���ʽ���.
        if (StringUtils.isEmpty(formula))
        {
            throw new IllegalArgumentException("���ʽ���Ϸ���formula = " + formula);
        }

        // ���ʽ����.
        formula = formula.trim().replaceAll("\\[", "").replaceAll("\\]", "");

        // JavaScript�ű�����.
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        // �㷨�������������ֵ-ȫ�ֱ���������ֵ.
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

        // Js����ִ��.
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
                throw new IllegalArgumentException("���ʽ���Ϸ���formula = " + formula);
            }
        }
        // ��װ��js��������ִ��.
        else if (formula.contains("if") || formula.contains("return"))
        {
            formula = "function smartCal() {formula}".replace("formula", formula);
            engine.eval(formula);
            invocable = (Invocable) engine;
            calResult = invocable.invokeFunction("smartCal", new Object());
        }
        // ֱ��ִ�б��ʽ.
        else
        {
            calResult = engine.eval(formula);
        }

        return calResult;
    }

    /**
     * �����㷨��Js���淵�ؼ�����ʽ(�ޱ���([variableName])��ʽ).
     * @param formula
     *      ������ʽ�����Ժ�function,if,return�ȹؼ���.
     * @param params
     * @return
     * @throws Exception
     */
    public static Object smartFormula(String formula, Map<String, Object> params) throws Exception
    {
        // �����㷨ִ�н��.
        Object formulaResult = null;

        // ���ʽ���.
        if (StringUtils.isEmpty(formula))
        {
            throw new IllegalArgumentException("���ʽ��ʽ���Ϸ���formula = " + formula);
        }

        // ���ʽ����.
        formula = formula.trim();

        // ��return�ؼ��֣�����ȡreturn�������(;)֮��ļ�����ʽ.
        if (formula.contains("return"))
        {
            // ���ʽ���.
            if (!formula.contains(";"))
            {
                throw new IllegalArgumentException("���ʽ��ʽ���Ϸ���formula = " + formula);
            }

            // ����ƥ�����ļ��ֱ��ʽ.
            List<String> formulaList = new ArrayList<String>();
            Matcher matcher = patternFormula.matcher(formula);
            while (matcher.find())
            {
                formulaList.add(matcher.group(1));
            }

            // �Ա��ʽ���м���Աȣ�ȷ���������õı��ʽ�����Ա�������ʵ��ֵ�����滻.
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
                    throw new IllegalArgumentException("���ʽ��ʽ���Ϸ���formula = " + formula);
                }
            }
            catch (Exception e)
            {
                throw new IllegalArgumentException("���ʽ��ʽ���Ϸ���formula = " + formula);
            }
        }
        else
        {
            formulaResult = formula(formula, params);
        }

        return formulaResult;
    }

    /**
     * �����㷨��Js���淵�ؼ�����ʽ(�ޱ���([variableName])��ʽ).
     * @param formula
     *      ������ʽ������function,if,return.
     * @param params
     * @return
     * @throws Exception
     */
    public static Object formula(String formula, Map<String, Object> params) throws Exception
    {
        // �����㷨ִ�н��.
        Object formulaResult = null;

        // ���ʽ���.
        if (StringUtils.isEmpty(formula) || formula.contains("if") || formula.contains("return") || formula.contains("function"))
        {
            throw new IllegalArgumentException("���ʽ��ʽ���Ϸ���formula = " + formula);
        }

        // ���ʽ����.
        formula = formula.trim();

        // ������飬�б������滻����Ϊ��ʵ������ֵ.
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
