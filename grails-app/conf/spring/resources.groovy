// Place your Spring DSL code here
import org.springframework.web.servlet.i18n.SessionLocaleResolver
beans = {
	localeResolver(org.springframework.web.servlet.i18n.SessionLocaleResolver) {
		defaultLocale = new Locale("vn");
		//defaultLocale= Locale.ENGLISH
		java.util.Locale.setDefault(defaultLocale);
	 }
	}
