package ejemplo.sergio.preferencias;

import android.content.SharedPreferences;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends PreferenceActivity {
    private int pulsar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);

        ListPreference listPreference = (ListPreference) findPreference("TiempoEspera");


        //devuelve el actual valor del tiempo
        listPreference.setSummary("tras " + listPreference.getEntry().toString() + " inactividad");


//cada vez que cambiemos el valor del tiempo
        listPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object nuevoValor) {
                preference.setSummary("tras " + nuevoValor.toString() + " inactividad");
                return true;
            }
        });



    }

};







