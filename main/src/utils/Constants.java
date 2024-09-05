package utils;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    private static Map<String, String> errorMessages = new HashMap<>();
    private static Map<String, String> skinCondition = new HashMap<>();
    private static Map<String, String> uvRead = new HashMap<>();

    public Constants() {
        errorMessages.put("sql_query_error", "<html>Error en la consulta sql</html>");
        errorMessages.put("number_format", "<html>Debe ingresar valor numerico donde se requiere</html>");
        errorMessages.put("failed_connection", "Fallo la conexion a BD</html>");
        errorMessages.put("date_format", "<html>Debe ingresar un formato de fecha valido (Ano-mes-dia)</html>");
        errorMessages.put("success", "Proceso exitoso!");
        errorMessages.put("success_update", "Datos actualizados!");
        errorMessages.put("success_config", "Configuracion exitosa!");
        errorMessages.put("success_registry", "Registro exitoso!");
        errorMessages.put("success_delete", "Registro eliminado!");
        errorMessages.put("success_delete_all", "<html>Se eliminaron todos los registros</html>");
        errorMessages.put("no_success", "Proceso no exitoso!");
        errorMessages.put("no_info", "<html>No se encontró informacion</html>");
        errorMessages.put("no_delete", "<html>La informacion no fue eliminada</html>");
        errorMessages.put("no_update", "<html>La informacion no fue actualizada</html>");
        errorMessages.put("empty_imputs", "<html>Hay campos vacios</html>");
        errorMessages.put("different_emails", "<html>Las direcciones email no coinciden</html>");
        errorMessages.put("different_password", "<html>Las contraseñas no coinciden</html>");
        errorMessages.put("email_format_invalid", "<html>Formato email invalido</html>");
        errorMessages.put("sensor_error", "<html>El sensor no ha podido establecer conexion</html>");

        skinCondition.put("burn", "<html>Se recomienda el uso de protector solar, mínimo SPF 30+ aplicado cada 2 horas</html>");
        skinCondition.put("cancer", "<html>Se recomienda el uso de protector solar de amplio espectro SPF 50+: Aplícalo incluso en días nublados.</html>");
        skinCondition.put("aging", "<html>Se recomienda aplicar antioxidantes tópicos como la vitamina C y uso de protector solar con SPF +30</html>");
        skinCondition.put("dermatitis", "<html>Viste ropa protectora de alta cobertura: Manga larga, sombreros de ala ancha y gafas de sol son esenciales.\n"
                + "Se recomienda el uso de protector solar de amplio espectro SPF 50+: Aplícalo cada 2 horas si estás al aire libre.</html>");
        skinCondition.put("lupus", "<html>Usa protector solar de amplio espectro SPF 50+: Aplicar con frecuencia es clave para evitar brotes.\n"
                + "Evita la exposición directa al sol: Mantente en interiores durante las horas pico de UV y usa ropa protectora.</html>");
        skinCondition.put("dermatosis", "<html>Evita la exposición al sol tanto como sea posible. Usa protector solar de amplio espectro SPF 50+ o más: \n"
                + "Reaplica cada 2 horas y después de sudar o nadar. Viste ropa protectora, incluyendo sombreros y gafas de sol: Incluso los guantes pueden ser necesarios en algunos casos.</html>");
        skinCondition.put("phototype_1", "<html>Usar protector solar SPF 50+. Evitar el sol entre 10 a.m. y 4 p.m.\n"
                + "Usar ropa de protección solar, sombreros de ala ancha y gafas de sol.</html>");
        skinCondition.put("phototype_2", "<html>Usar protector solar SPF 50+.</html>");
        skinCondition.put("phototype_3", "<html>Usar protector solar SPF 30-50.</html>");
        skinCondition.put("phototype_4", "<html>Usar protector solar SPF 30+.</html>");
        skinCondition.put("phototype_5", "<html>Usar protector solar SPF 15-30.</html>");
        skinCondition.put("phototype_6", "<html>Usar protector solar SPF 15-30.</html>");
        skinCondition.put("general", "<html>Alerta por altos indices de radiacion solar en su ubicacion</html>");
        skinCondition.put("low_level", "<html>Un gran dia para salir a caminar.</html>");
        skinCondition.put("high_level", "<html>Precaucion, altos niveles de radiacion en su Ciudad.</html>");
        uvRead.put("limit_exposition", "<html>Usted ha llegado al limite de exposicion diaria.</html>");
    }

    public static String getUvRead(String key) {
        return uvRead.get(key);
    }

    public static String get_message(String key) {
        return errorMessages.get(key);
    }

    public static String get_recommendation(String key) {
        return skinCondition.get(key);
    }
}
