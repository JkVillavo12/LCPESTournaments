package com.jkvillavo12dev.lcpestournaments.utils.sharedprefs;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Clase encargada del control de preferencias en la app
 * Creado el 22/04/2016 a las 10:13 AM <br>
 *
 * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
 */
public class SharedPrefs {

   /**
    * Elimina un grupo de preferencias
    * Creado el 22/04/2016 a las 10:08 AM <br>
    *
    * @param keyPreferences key del grupo de preferencias
    * @param context        contexto
    *
    * @return true si logra eliminar las preferencias, false sino puede hacerlo
    *
    * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
    */
   public static boolean eliminarPreferencias (String keyPreferences, Context context) {

      SharedPreferences prefs = context.getSharedPreferences(keyPreferences, Context.MODE_PRIVATE);
      boolean isEliminadaSharedPreferences = false;
      if (prefs != null) {
         SharedPreferences.Editor editor = prefs.edit();
         editor.clear();
         editor.commit();
         if (prefs.getAll().size() == 0) {
            isEliminadaSharedPreferences = true;
         }
      }
      return isEliminadaSharedPreferences;
   }

   /**
    * Elimina una preferencia segun su grupo y la key unica para la shared
    *
    * @param keyGroupPreference key del grupo de preferencias
    * @param keyPreference      key de la preferencia
    * @param context            contexto
    *
    * @return true si logra eliminarla, false sino puede hacerlo
    */
   public static boolean eliminarPreferencia (String keyGroupPreference, String keyPreference, Context context) {

      SharedPreferences preferences = SharedPrefs.obtenerPreferencia(context, keyGroupPreference);
      if (preferences != null) {
         if (preferences.contains(keyPreference)) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.remove(keyPreference);
            editor.commit();
            return true;
         }
      }
      return false;
   }

   /**
    * Guarda la informacion de un grupo de preferencias por medio del keygroup
    * Creado el 22/04/2016 a las 10:11 AM <br>
    *
    * @param context            contexto
    * @param keyGroupPreference key del grupo de preferencias
    * @param datos              datos a guardar
    *
    * @return
    *
    * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
    */
   public static boolean guardarPreferencia (Context context, String keyGroupPreference, HashMap<String, Object> datos) {

      SharedPreferences prefs = context.getSharedPreferences(keyGroupPreference, Context.MODE_PRIVATE);
      SharedPreferences.Editor infoPreferencias = prefs.edit();

      // debemos recorrer el mapa e ir seteando los valores en el bundle del sharedPreferences
      Iterator<Map.Entry<String, Object>> it = datos.entrySet().iterator();
      while (it.hasNext()) {
         Map.Entry valorDatoMapa = (Map.Entry) it.next();
         if (valorDatoMapa.getValue() instanceof String) {
            infoPreferencias.putString(String.valueOf(valorDatoMapa.getKey()), (String) valorDatoMapa.getValue());
         } else if (valorDatoMapa.getValue() instanceof Boolean) {
            infoPreferencias.putBoolean(String.valueOf(valorDatoMapa.getKey()), (Boolean) valorDatoMapa.getValue());
         } else if (valorDatoMapa.getValue() instanceof Integer) {
            infoPreferencias.putInt(String.valueOf(valorDatoMapa.getKey()), (Integer) valorDatoMapa.getValue());
         } else if (valorDatoMapa.getValue() instanceof Long) {
            infoPreferencias.putLong(String.valueOf(valorDatoMapa.getKey()), (Long) valorDatoMapa.getValue());
         } else if (valorDatoMapa.getValue() instanceof List<?>) {
            infoPreferencias.putStringSet(String.valueOf(valorDatoMapa.getKey()), obtenerStringSetFromList(valorDatoMapa.getValue()));
         }
      }

      infoPreferencias.commit();

      return true;
   }

   /**
    * obtiene un Set<String> a partir de una lista
    * Creado el 22/04/2016 a las 10:11 AM <br>
    *
    * @param value lista de entrada
    *
    * @return set de string de la lista
    *
    * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
    */
   private static Set<String> obtenerStringSetFromList (Object value) {

      List<String> listaIn = ((List<String>) value);
      Set<String> out = new HashSet<String>();
      out.addAll(listaIn);
      return out;
   }

   /**
    * Obtiene una preferencia dada su key del grupo
    * Creado el 22/04/2016 a las 10:12 AM <br>
    *
    * @param context  contexto
    * @param prefsKey key del grupo de preferencia
    *
    * @return Paquete de sharedPreferencias
    *
    * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
    */
   public static SharedPreferences obtenerPreferencia (Context context, String prefsKey) {

      return context.getSharedPreferences(prefsKey, Context.MODE_PRIVATE);
   }

}
