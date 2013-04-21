package com.att.phutungoto
import java.util.List;
import java.util.Map;
import org.grails.plugins.excelimport.ExcelImportService;
import org.grails.plugins.excelimport.AbstractExcelImporter;
class ArticleImportService  extends AbstractExcelImporter {

	def excelImportService
//	def getExcelImportService() {
//		ExcelImportService.getService()
//	}

	static Map CONFIG_ARTICLE_COLUMN_MAP = [sheet:'Sheet1',
		startRow: 1,
		columnMap:  [
			'B':'code',
			'C':'name',
			'P':'quantity',
			'F' :'unite',
			'I': 'prix'
		]
	]


	public ArticleImportService(String fileName) {
		super(fileName);
		// TODO Auto-generated constructor stub
	}


	List<Map> getArticles(){
		List articleList= ExcelImportService.getService().columns(workbook, CONFIG_ARTICLE_COLUMN_MAP);
	}
	
}
