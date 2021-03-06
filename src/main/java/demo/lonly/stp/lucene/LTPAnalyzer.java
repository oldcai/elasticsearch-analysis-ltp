/**
 * 玻森数据 中文分词 版本 0.8.2
 *
 */
package demo.lonly.stp.lucene;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Tokenizer;
import org.json.JSONException;

import java.io.IOException;


/**
 * Implementation of ltp word segmenter
 * on Lucene Analyzer interface
 */
public final class LTPAnalyzer extends Analyzer {

    public LTPAnalyzer(){
    	super();
    }
    
    @Override
    protected TokenStreamComponents createComponents(String fieldName){
        Tokenizer tokenizer = null;
        try {

            tokenizer = new LTPTokenizer();
        } catch (IOException | JSONException | UnirestException e) {
            e.printStackTrace();
        }
        return new TokenStreamComponents(tokenizer);
    }
   
}
