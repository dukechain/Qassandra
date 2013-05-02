// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g 2013-05-02 18:11:24

    package org.apache.cassandra.cql3;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Collections;
    import java.util.EnumSet;
    import java.util.HashMap;
    import java.util.LinkedHashMap;
    import java.util.List;
    import java.util.Map;
    import java.util.Set;

    import org.apache.cassandra.auth.Permission;
    import org.apache.cassandra.auth.DataResource;
    import org.apache.cassandra.auth.IResource;
    import org.apache.cassandra.cql3.*;
    import org.apache.cassandra.cql3.statements.*;
    import org.apache.cassandra.cql3.functions.FunctionCall;
    import org.apache.cassandra.db.marshal.CollectionType;
    import org.apache.cassandra.exceptions.ConfigurationException;
    import org.apache.cassandra.exceptions.InvalidRequestException;
    import org.apache.cassandra.exceptions.SyntaxException;
    import org.apache.cassandra.utils.Pair;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CqlParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "K_USE", "K_SELECT", "K_COUNT", "K_FROM", "K_WHERE", "K_ORDER", "K_BY", "K_LIMIT", "INTEGER", "K_ALLOW", "K_FILTERING", "K_WRITETIME", "K_TTL", "K_AND", "K_ASC", "K_DESC", "K_INSERT", "K_INTO", "K_VALUES", "K_USING", "K_TIMESTAMP", "K_UPDATE", "K_SET", "K_IF", "K_NOT", "K_EXISTS", "K_DELETE", "K_BEGIN", "K_UNLOGGED", "K_COUNTER", "K_BATCH", "K_APPLY", "K_CREATE", "K_KEYSPACE", "K_WITH", "K_COLUMNFAMILY", "K_PRIMARY", "K_KEY", "K_COMPACT", "K_STORAGE", "K_CLUSTERING", "K_INDEX", "IDENT", "K_ON", "K_ALTER", "K_TYPE", "K_ADD", "K_DROP", "K_RENAME", "K_TO", "K_TRUNCATE", "K_GRANT", "K_REVOKE", "K_LIST", "K_OF", "K_NORECURSIVE", "K_MODIFY", "K_AUTHORIZE", "K_ALL", "K_PERMISSIONS", "K_PERMISSION", "K_KEYSPACES", "K_USER", "K_SUPERUSER", "K_NOSUPERUSER", "K_USERS", "K_PASSWORD", "STRING_LITERAL", "QUOTED_NAME", "FLOAT", "BOOLEAN", "UUID", "HEXNUMBER", "K_NULL", "QMARK", "K_TOKEN", "K_IN", "K_ASCII", "K_BIGINT", "K_BLOB", "K_BOOLEAN", "K_DECIMAL", "K_DOUBLE", "K_FLOAT", "K_INET", "K_INT", "K_TEXT", "K_UUID", "K_VARCHAR", "K_VARINT", "K_TIMEUUID", "K_MAP", "S", "E", "L", "C", "T", "F", "R", "O", "M", "W", "H", "A", "N", "D", "K", "Y", "I", "U", "P", "G", "B", "X", "V", "Z", "J", "Q", "DIGIT", "LETTER", "HEX", "EXPONENT", "WS", "COMMENT", "MULTILINE_COMMENT", "';'", "'('", "')'", "','", "'\\*'", "'['", "']'", "'.'", "'}'", "':'", "'{'", "'='", "'+'", "'-'", "'<'", "'<='", "'>'", "'>='"
    };
    public static final int EXPONENT=125;
    public static final int K_PERMISSIONS=63;
    public static final int LETTER=123;
    public static final int K_INT=89;
    public static final int K_PERMISSION=64;
    public static final int K_CREATE=36;
    public static final int K_CLUSTERING=44;
    public static final int K_WRITETIME=15;
    public static final int K_EXISTS=29;
    public static final int EOF=-1;
    public static final int K_PRIMARY=40;
    public static final int K_AUTHORIZE=61;
    public static final int K_VALUES=22;
    public static final int K_USE=4;
    public static final int STRING_LITERAL=71;
    public static final int K_GRANT=55;
    public static final int K_ON=47;
    public static final int K_USING=23;
    public static final int K_ADD=50;
    public static final int K_ASC=18;
    public static final int K_KEY=41;
    public static final int COMMENT=127;
    public static final int K_TRUNCATE=54;
    public static final int K_ORDER=9;
    public static final int HEXNUMBER=76;
    public static final int K_OF=58;
    public static final int K_ALL=62;
    public static final int D=109;
    public static final int T__139=139;
    public static final int E=97;
    public static final int T__138=138;
    public static final int F=101;
    public static final int T__137=137;
    public static final int G=115;
    public static final int T__136=136;
    public static final int K_COUNT=6;
    public static final int K_KEYSPACE=37;
    public static final int K_TYPE=49;
    public static final int A=107;
    public static final int B=116;
    public static final int C=99;
    public static final int L=98;
    public static final int M=104;
    public static final int N=108;
    public static final int O=103;
    public static final int H=106;
    public static final int I=112;
    public static final int J=120;
    public static final int K_UPDATE=25;
    public static final int K=110;
    public static final int K_FILTERING=14;
    public static final int U=113;
    public static final int T=100;
    public static final int W=105;
    public static final int K_TEXT=90;
    public static final int V=118;
    public static final int Q=121;
    public static final int P=114;
    public static final int K_COMPACT=42;
    public static final int S=96;
    public static final int R=102;
    public static final int T__141=141;
    public static final int T__142=142;
    public static final int K_TTL=16;
    public static final int T__140=140;
    public static final int Y=111;
    public static final int T__145=145;
    public static final int X=117;
    public static final int T__146=146;
    public static final int T__143=143;
    public static final int Z=119;
    public static final int T__144=144;
    public static final int K_INDEX=45;
    public static final int K_INSERT=20;
    public static final int WS=126;
    public static final int T__129=129;
    public static final int K_NOT=28;
    public static final int K_RENAME=52;
    public static final int K_APPLY=35;
    public static final int K_INET=88;
    public static final int K_STORAGE=43;
    public static final int K_TIMESTAMP=24;
    public static final int K_NULL=77;
    public static final int K_AND=17;
    public static final int K_DESC=19;
    public static final int T__130=130;
    public static final int K_TOKEN=79;
    public static final int QMARK=78;
    public static final int T__131=131;
    public static final int T__132=132;
    public static final int T__133=133;
    public static final int T__134=134;
    public static final int K_UUID=91;
    public static final int T__135=135;
    public static final int K_BATCH=34;
    public static final int K_ASCII=81;
    public static final int UUID=75;
    public static final int K_LIST=57;
    public static final int K_DELETE=30;
    public static final int K_TO=53;
    public static final int K_BY=10;
    public static final int FLOAT=73;
    public static final int K_VARINT=93;
    public static final int K_FLOAT=87;
    public static final int K_SUPERUSER=67;
    public static final int K_DOUBLE=86;
    public static final int K_SELECT=5;
    public static final int K_LIMIT=11;
    public static final int K_BOOLEAN=84;
    public static final int K_ALTER=48;
    public static final int K_SET=26;
    public static final int K_WHERE=8;
    public static final int QUOTED_NAME=72;
    public static final int MULTILINE_COMMENT=128;
    public static final int K_BLOB=83;
    public static final int BOOLEAN=74;
    public static final int K_UNLOGGED=32;
    public static final int HEX=124;
    public static final int K_INTO=21;
    public static final int K_PASSWORD=70;
    public static final int K_REVOKE=56;
    public static final int K_ALLOW=13;
    public static final int K_VARCHAR=92;
    public static final int IDENT=46;
    public static final int DIGIT=122;
    public static final int K_USERS=69;
    public static final int K_BEGIN=31;
    public static final int INTEGER=12;
    public static final int K_KEYSPACES=65;
    public static final int K_COUNTER=33;
    public static final int K_DECIMAL=85;
    public static final int K_WITH=38;
    public static final int K_IN=80;
    public static final int K_NORECURSIVE=59;
    public static final int K_MAP=95;
    public static final int K_IF=27;
    public static final int K_FROM=7;
    public static final int K_COLUMNFAMILY=39;
    public static final int K_MODIFY=60;
    public static final int K_DROP=51;
    public static final int K_NOSUPERUSER=68;
    public static final int K_BIGINT=82;
    public static final int K_TIMEUUID=94;
    public static final int K_USER=66;

    // delegates
    // delegators


        public CqlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CqlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return CqlParser.tokenNames; }
    public String getGrammarFileName() { return "/home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g"; }


        private List<String> recognitionErrors = new ArrayList<String>();
        private int currentBindMarkerIdx = -1;

        public void displayRecognitionError(String[] tokenNames, RecognitionException e)
        {
            String hdr = getErrorHeader(e);
            String msg = getErrorMessage(e, tokenNames);
            recognitionErrors.add(hdr + " " + msg);
        }

        public void addRecognitionError(String msg)
        {
            recognitionErrors.add(msg);
        }

        public List<String> getRecognitionErrors()
        {
            return recognitionErrors;
        }

        public void throwLastRecognitionError() throws SyntaxException
        {
            if (recognitionErrors.size() > 0)
                throw new SyntaxException(recognitionErrors.get((recognitionErrors.size()-1)));
        }

        public Map<String, String> convertPropertyMap(Maps.Literal map)
        {
            if (map == null || map.entries == null || map.entries.isEmpty())
                return Collections.<String, String>emptyMap();

            Map<String, String> res = new HashMap<String, String>(map.entries.size());

            for (Pair<Term.Raw, Term.Raw> entry : map.entries)
            {
                // Because the parser tries to be smart and recover on error (to
                // allow displaying more than one error I suppose), we have null
                // entries in there. Just skip those, a proper error will be thrown in the end.
                if (entry.left == null || entry.right == null)
                    break;

                if (!(entry.left instanceof Constants.Literal))
                {
                    addRecognitionError("Invalid property name: " + entry.left);
                    break;
                }
                if (!(entry.right instanceof Constants.Literal))
                {
                    addRecognitionError("Invalid property value: " + entry.right);
                    break;
                }

                res.put(((Constants.Literal)entry.left).getRawText(), ((Constants.Literal)entry.right).getRawText());
            }

            return res;
        }

        public void addRawUpdate(List<Pair<ColumnIdentifier, Operation.RawUpdate>> operations, ColumnIdentifier key, Operation.RawUpdate update)
        {
            for (Pair<ColumnIdentifier, Operation.RawUpdate> p : operations)
            {
                if (p.left.equals(key) && !p.right.isCompatibleWith(update))
                    addRecognitionError("Multiple incompatible setting of column " + key);
            }
            operations.add(Pair.create(key, update));
        }



    // $ANTLR start "query"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:166:1: query returns [ParsedStatement stmnt] : st= cqlStatement ( ';' )* EOF ;
    public final ParsedStatement query() throws RecognitionException {
        ParsedStatement stmnt = null;

        ParsedStatement st = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:169:5: (st= cqlStatement ( ';' )* EOF )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:169:7: st= cqlStatement ( ';' )* EOF
            {
            pushFollow(FOLLOW_cqlStatement_in_query72);
            st=cqlStatement();

            state._fsp--;

            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:169:23: ( ';' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==129) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:169:24: ';'
            	    {
            	    match(input,129,FOLLOW_129_in_query75); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match(input,EOF,FOLLOW_EOF_in_query79); 
             stmnt = st; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmnt;
    }
    // $ANTLR end "query"


    // $ANTLR start "cqlStatement"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:172:1: cqlStatement returns [ParsedStatement stmt] : (st1= selectStatement | st2= insertStatement | st3= updateStatement | st4= batchStatement | st5= deleteStatement | st6= useStatement | st7= truncateStatement | st8= createKeyspaceStatement | st9= createColumnFamilyStatement | st10= createIndexStatement | st11= dropKeyspaceStatement | st12= dropColumnFamilyStatement | st13= dropIndexStatement | st14= alterTableStatement | st15= alterKeyspaceStatement | st16= grantStatement | st17= revokeStatement | st18= listPermissionsStatement | st19= createUserStatement | st20= alterUserStatement | st21= dropUserStatement | st22= listUsersStatement );
    public final ParsedStatement cqlStatement() throws RecognitionException {
        ParsedStatement stmt = null;

        SelectStatement.RawStatement st1 = null;

        UpdateStatement.ParsedInsert st2 = null;

        UpdateStatement.ParsedUpdate st3 = null;

        BatchStatement.Parsed st4 = null;

        DeleteStatement.Parsed st5 = null;

        UseStatement st6 = null;

        TruncateStatement st7 = null;

        CreateKeyspaceStatement st8 = null;

        CreateColumnFamilyStatement.RawStatement st9 = null;

        CreateIndexStatement st10 = null;

        DropKeyspaceStatement st11 = null;

        DropColumnFamilyStatement st12 = null;

        DropIndexStatement st13 = null;

        AlterTableStatement st14 = null;

        AlterKeyspaceStatement st15 = null;

        GrantStatement st16 = null;

        RevokeStatement st17 = null;

        ListPermissionsStatement st18 = null;

        CreateUserStatement st19 = null;

        AlterUserStatement st20 = null;

        DropUserStatement st21 = null;

        ListUsersStatement st22 = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:174:5: (st1= selectStatement | st2= insertStatement | st3= updateStatement | st4= batchStatement | st5= deleteStatement | st6= useStatement | st7= truncateStatement | st8= createKeyspaceStatement | st9= createColumnFamilyStatement | st10= createIndexStatement | st11= dropKeyspaceStatement | st12= dropColumnFamilyStatement | st13= dropIndexStatement | st14= alterTableStatement | st15= alterKeyspaceStatement | st16= grantStatement | st17= revokeStatement | st18= listPermissionsStatement | st19= createUserStatement | st20= alterUserStatement | st21= dropUserStatement | st22= listUsersStatement )
            int alt2=22;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:174:7: st1= selectStatement
                    {
                    pushFollow(FOLLOW_selectStatement_in_cqlStatement113);
                    st1=selectStatement();

                    state._fsp--;

                     stmt = st1; 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:175:7: st2= insertStatement
                    {
                    pushFollow(FOLLOW_insertStatement_in_cqlStatement138);
                    st2=insertStatement();

                    state._fsp--;

                     stmt = st2; 

                    }
                    break;
                case 3 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:176:7: st3= updateStatement
                    {
                    pushFollow(FOLLOW_updateStatement_in_cqlStatement163);
                    st3=updateStatement();

                    state._fsp--;

                     stmt = st3; 

                    }
                    break;
                case 4 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:177:7: st4= batchStatement
                    {
                    pushFollow(FOLLOW_batchStatement_in_cqlStatement188);
                    st4=batchStatement();

                    state._fsp--;

                     stmt = st4; 

                    }
                    break;
                case 5 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:178:7: st5= deleteStatement
                    {
                    pushFollow(FOLLOW_deleteStatement_in_cqlStatement214);
                    st5=deleteStatement();

                    state._fsp--;

                     stmt = st5; 

                    }
                    break;
                case 6 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:179:7: st6= useStatement
                    {
                    pushFollow(FOLLOW_useStatement_in_cqlStatement239);
                    st6=useStatement();

                    state._fsp--;

                     stmt = st6; 

                    }
                    break;
                case 7 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:180:7: st7= truncateStatement
                    {
                    pushFollow(FOLLOW_truncateStatement_in_cqlStatement267);
                    st7=truncateStatement();

                    state._fsp--;

                     stmt = st7; 

                    }
                    break;
                case 8 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:181:7: st8= createKeyspaceStatement
                    {
                    pushFollow(FOLLOW_createKeyspaceStatement_in_cqlStatement290);
                    st8=createKeyspaceStatement();

                    state._fsp--;

                     stmt = st8; 

                    }
                    break;
                case 9 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:182:7: st9= createColumnFamilyStatement
                    {
                    pushFollow(FOLLOW_createColumnFamilyStatement_in_cqlStatement307);
                    st9=createColumnFamilyStatement();

                    state._fsp--;

                     stmt = st9; 

                    }
                    break;
                case 10 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:183:7: st10= createIndexStatement
                    {
                    pushFollow(FOLLOW_createIndexStatement_in_cqlStatement319);
                    st10=createIndexStatement();

                    state._fsp--;

                     stmt = st10; 

                    }
                    break;
                case 11 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:184:7: st11= dropKeyspaceStatement
                    {
                    pushFollow(FOLLOW_dropKeyspaceStatement_in_cqlStatement338);
                    st11=dropKeyspaceStatement();

                    state._fsp--;

                     stmt = st11; 

                    }
                    break;
                case 12 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:185:7: st12= dropColumnFamilyStatement
                    {
                    pushFollow(FOLLOW_dropColumnFamilyStatement_in_cqlStatement356);
                    st12=dropColumnFamilyStatement();

                    state._fsp--;

                     stmt = st12; 

                    }
                    break;
                case 13 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:186:7: st13= dropIndexStatement
                    {
                    pushFollow(FOLLOW_dropIndexStatement_in_cqlStatement370);
                    st13=dropIndexStatement();

                    state._fsp--;

                     stmt = st13; 

                    }
                    break;
                case 14 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:187:7: st14= alterTableStatement
                    {
                    pushFollow(FOLLOW_alterTableStatement_in_cqlStatement391);
                    st14=alterTableStatement();

                    state._fsp--;

                     stmt = st14; 

                    }
                    break;
                case 15 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:188:7: st15= alterKeyspaceStatement
                    {
                    pushFollow(FOLLOW_alterKeyspaceStatement_in_cqlStatement411);
                    st15=alterKeyspaceStatement();

                    state._fsp--;

                     stmt = st15; 

                    }
                    break;
                case 16 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:189:7: st16= grantStatement
                    {
                    pushFollow(FOLLOW_grantStatement_in_cqlStatement428);
                    st16=grantStatement();

                    state._fsp--;

                     stmt = st16; 

                    }
                    break;
                case 17 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:190:7: st17= revokeStatement
                    {
                    pushFollow(FOLLOW_revokeStatement_in_cqlStatement453);
                    st17=revokeStatement();

                    state._fsp--;

                     stmt = st17; 

                    }
                    break;
                case 18 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:191:7: st18= listPermissionsStatement
                    {
                    pushFollow(FOLLOW_listPermissionsStatement_in_cqlStatement477);
                    st18=listPermissionsStatement();

                    state._fsp--;

                     stmt = st18; 

                    }
                    break;
                case 19 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:192:7: st19= createUserStatement
                    {
                    pushFollow(FOLLOW_createUserStatement_in_cqlStatement492);
                    st19=createUserStatement();

                    state._fsp--;

                     stmt = st19; 

                    }
                    break;
                case 20 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:193:7: st20= alterUserStatement
                    {
                    pushFollow(FOLLOW_alterUserStatement_in_cqlStatement512);
                    st20=alterUserStatement();

                    state._fsp--;

                     stmt = st20; 

                    }
                    break;
                case 21 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:194:7: st21= dropUserStatement
                    {
                    pushFollow(FOLLOW_dropUserStatement_in_cqlStatement533);
                    st21=dropUserStatement();

                    state._fsp--;

                     stmt = st21; 

                    }
                    break;
                case 22 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:195:7: st22= listUsersStatement
                    {
                    pushFollow(FOLLOW_listUsersStatement_in_cqlStatement555);
                    st22=listUsersStatement();

                    state._fsp--;

                     stmt = st22; 

                    }
                    break;

            }
             if (stmt != null) stmt.setBoundTerms(currentBindMarkerIdx + 1); 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "cqlStatement"


    // $ANTLR start "useStatement"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:201:1: useStatement returns [UseStatement stmt] : K_USE ks= keyspaceName ;
    public final UseStatement useStatement() throws RecognitionException {
        UseStatement stmt = null;

        String ks = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:202:5: ( K_USE ks= keyspaceName )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:202:7: K_USE ks= keyspaceName
            {
            match(input,K_USE,FOLLOW_K_USE_in_useStatement589); 
            pushFollow(FOLLOW_keyspaceName_in_useStatement593);
            ks=keyspaceName();

            state._fsp--;

             stmt = new UseStatement(ks); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "useStatement"


    // $ANTLR start "selectStatement"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:205:1: selectStatement returns [SelectStatement.RawStatement expr] : K_SELECT (sclause= selectClause | ( K_COUNT '(' sclause= selectCountClause ')' ) ) K_FROM cf= columnFamilyName ( K_WHERE wclause= whereClause )? ( K_ORDER K_BY orderByClause[orderings] ( ',' orderByClause[orderings] )* )? ( K_LIMIT rows= INTEGER )? ( K_ALLOW K_FILTERING )? ;
    public final SelectStatement.RawStatement selectStatement() throws RecognitionException {
        SelectStatement.RawStatement expr = null;

        Token rows=null;
        List<RawSelector> sclause = null;

        CFName cf = null;

        List<Relation> wclause = null;



                boolean isCount = false;
                int limit = Integer.MAX_VALUE;
                Map<ColumnIdentifier, Boolean> orderings = new LinkedHashMap<ColumnIdentifier, Boolean>();
                boolean allowFiltering = false;
            
        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:218:5: ( K_SELECT (sclause= selectClause | ( K_COUNT '(' sclause= selectCountClause ')' ) ) K_FROM cf= columnFamilyName ( K_WHERE wclause= whereClause )? ( K_ORDER K_BY orderByClause[orderings] ( ',' orderByClause[orderings] )* )? ( K_LIMIT rows= INTEGER )? ( K_ALLOW K_FILTERING )? )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:218:7: K_SELECT (sclause= selectClause | ( K_COUNT '(' sclause= selectCountClause ')' ) ) K_FROM cf= columnFamilyName ( K_WHERE wclause= whereClause )? ( K_ORDER K_BY orderByClause[orderings] ( ',' orderByClause[orderings] )* )? ( K_LIMIT rows= INTEGER )? ( K_ALLOW K_FILTERING )?
            {
            match(input,K_SELECT,FOLLOW_K_SELECT_in_selectStatement627); 
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:218:16: (sclause= selectClause | ( K_COUNT '(' sclause= selectCountClause ')' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=K_FILTERING && LA3_0<=K_TTL)||LA3_0==K_VALUES||LA3_0==K_TIMESTAMP||LA3_0==K_EXISTS||LA3_0==K_COUNTER||(LA3_0>=K_KEY && LA3_0<=K_CLUSTERING)||LA3_0==IDENT||LA3_0==K_TYPE||LA3_0==K_LIST||(LA3_0>=K_ALL && LA3_0<=K_PASSWORD)||LA3_0==QUOTED_NAME||LA3_0==K_TOKEN||(LA3_0>=K_ASCII && LA3_0<=K_MAP)||LA3_0==133) ) {
                alt3=1;
            }
            else if ( (LA3_0==K_COUNT) ) {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==130) ) {
                    alt3=2;
                }
                else if ( (LA3_2==K_FROM||LA3_2==132) ) {
                    alt3=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:218:18: sclause= selectClause
                    {
                    pushFollow(FOLLOW_selectClause_in_selectStatement633);
                    sclause=selectClause();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:218:41: ( K_COUNT '(' sclause= selectCountClause ')' )
                    {
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:218:41: ( K_COUNT '(' sclause= selectCountClause ')' )
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:218:42: K_COUNT '(' sclause= selectCountClause ')'
                    {
                    match(input,K_COUNT,FOLLOW_K_COUNT_in_selectStatement638); 
                    match(input,130,FOLLOW_130_in_selectStatement640); 
                    pushFollow(FOLLOW_selectCountClause_in_selectStatement644);
                    sclause=selectCountClause();

                    state._fsp--;

                    match(input,131,FOLLOW_131_in_selectStatement646); 
                     isCount = true; 

                    }


                    }
                    break;

            }

            match(input,K_FROM,FOLLOW_K_FROM_in_selectStatement659); 
            pushFollow(FOLLOW_columnFamilyName_in_selectStatement663);
            cf=columnFamilyName();

            state._fsp--;

            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:220:7: ( K_WHERE wclause= whereClause )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==K_WHERE) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:220:9: K_WHERE wclause= whereClause
                    {
                    match(input,K_WHERE,FOLLOW_K_WHERE_in_selectStatement673); 
                    pushFollow(FOLLOW_whereClause_in_selectStatement677);
                    wclause=whereClause();

                    state._fsp--;


                    }
                    break;

            }

            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:221:7: ( K_ORDER K_BY orderByClause[orderings] ( ',' orderByClause[orderings] )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==K_ORDER) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:221:9: K_ORDER K_BY orderByClause[orderings] ( ',' orderByClause[orderings] )*
                    {
                    match(input,K_ORDER,FOLLOW_K_ORDER_in_selectStatement690); 
                    match(input,K_BY,FOLLOW_K_BY_in_selectStatement692); 
                    pushFollow(FOLLOW_orderByClause_in_selectStatement694);
                    orderByClause(orderings);

                    state._fsp--;

                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:221:47: ( ',' orderByClause[orderings] )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==132) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:221:49: ',' orderByClause[orderings]
                    	    {
                    	    match(input,132,FOLLOW_132_in_selectStatement699); 
                    	    pushFollow(FOLLOW_orderByClause_in_selectStatement701);
                    	    orderByClause(orderings);

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:222:7: ( K_LIMIT rows= INTEGER )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==K_LIMIT) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:222:9: K_LIMIT rows= INTEGER
                    {
                    match(input,K_LIMIT,FOLLOW_K_LIMIT_in_selectStatement718); 
                    rows=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_selectStatement722); 
                     limit = Integer.parseInt((rows!=null?rows.getText():null)); 

                    }
                    break;

            }

            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:223:7: ( K_ALLOW K_FILTERING )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==K_ALLOW) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:223:9: K_ALLOW K_FILTERING
                    {
                    match(input,K_ALLOW,FOLLOW_K_ALLOW_in_selectStatement737); 
                    match(input,K_FILTERING,FOLLOW_K_FILTERING_in_selectStatement739); 
                     allowFiltering = true; 

                    }
                    break;

            }


                      SelectStatement.Parameters params = new SelectStatement.Parameters(limit,
                                                                                         orderings,
                                                                                         isCount,
                                                                                         allowFiltering);
                      expr = new SelectStatement.RawStatement(cf, params, sclause, wclause);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "selectStatement"


    // $ANTLR start "selectClause"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:233:1: selectClause returns [List<RawSelector> expr] : (t1= selector ( ',' tN= selector )* | '\\*' );
    public final List<RawSelector> selectClause() throws RecognitionException {
        List<RawSelector> expr = null;

        RawSelector t1 = null;

        RawSelector tN = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:234:5: (t1= selector ( ',' tN= selector )* | '\\*' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==K_COUNT||(LA10_0>=K_FILTERING && LA10_0<=K_TTL)||LA10_0==K_VALUES||LA10_0==K_TIMESTAMP||LA10_0==K_EXISTS||LA10_0==K_COUNTER||(LA10_0>=K_KEY && LA10_0<=K_CLUSTERING)||LA10_0==IDENT||LA10_0==K_TYPE||LA10_0==K_LIST||(LA10_0>=K_ALL && LA10_0<=K_PASSWORD)||LA10_0==QUOTED_NAME||LA10_0==K_TOKEN||(LA10_0>=K_ASCII && LA10_0<=K_MAP)) ) {
                alt10=1;
            }
            else if ( (LA10_0==133) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:234:7: t1= selector ( ',' tN= selector )*
                    {
                    pushFollow(FOLLOW_selector_in_selectClause776);
                    t1=selector();

                    state._fsp--;

                     expr = new ArrayList<RawSelector>(); expr.add(t1); 
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:234:76: ( ',' tN= selector )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==132) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:234:77: ',' tN= selector
                    	    {
                    	    match(input,132,FOLLOW_132_in_selectClause781); 
                    	    pushFollow(FOLLOW_selector_in_selectClause785);
                    	    tN=selector();

                    	    state._fsp--;

                    	     expr.add(tN); 

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:235:7: '\\*'
                    {
                    match(input,133,FOLLOW_133_in_selectClause797); 
                     expr = Collections.<RawSelector>emptyList();

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "selectClause"


    // $ANTLR start "selectionFunctionArgs"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:238:1: selectionFunctionArgs returns [List<RawSelector> a] : ( '(' ')' | '(' s1= selector ( ',' sn= selector )* ')' );
    public final List<RawSelector> selectionFunctionArgs() throws RecognitionException {
        List<RawSelector> a = null;

        RawSelector s1 = null;

        RawSelector sn = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:239:5: ( '(' ')' | '(' s1= selector ( ',' sn= selector )* ')' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==130) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==131) ) {
                    alt12=1;
                }
                else if ( (LA12_1==K_COUNT||(LA12_1>=K_FILTERING && LA12_1<=K_TTL)||LA12_1==K_VALUES||LA12_1==K_TIMESTAMP||LA12_1==K_EXISTS||LA12_1==K_COUNTER||(LA12_1>=K_KEY && LA12_1<=K_CLUSTERING)||LA12_1==IDENT||LA12_1==K_TYPE||LA12_1==K_LIST||(LA12_1>=K_ALL && LA12_1<=K_PASSWORD)||LA12_1==QUOTED_NAME||LA12_1==K_TOKEN||(LA12_1>=K_ASCII && LA12_1<=K_MAP)) ) {
                    alt12=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:239:7: '(' ')'
                    {
                    match(input,130,FOLLOW_130_in_selectionFunctionArgs820); 
                    match(input,131,FOLLOW_131_in_selectionFunctionArgs822); 
                     a = Collections.emptyList(); 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:240:7: '(' s1= selector ( ',' sn= selector )* ')'
                    {
                    match(input,130,FOLLOW_130_in_selectionFunctionArgs832); 
                    pushFollow(FOLLOW_selector_in_selectionFunctionArgs836);
                    s1=selector();

                    state._fsp--;

                     List<RawSelector> args = new ArrayList<RawSelector>(); args.add(s1); 
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:241:11: ( ',' sn= selector )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==132) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:241:13: ',' sn= selector
                    	    {
                    	    match(input,132,FOLLOW_132_in_selectionFunctionArgs852); 
                    	    pushFollow(FOLLOW_selector_in_selectionFunctionArgs856);
                    	    sn=selector();

                    	    state._fsp--;

                    	     args.add(sn); 

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    match(input,131,FOLLOW_131_in_selectionFunctionArgs870); 
                     a = args; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return a;
    }
    // $ANTLR end "selectionFunctionArgs"


    // $ANTLR start "selector"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:245:1: selector returns [RawSelector s] : (c= cident | K_WRITETIME '(' c= cident ')' | K_TTL '(' c= cident ')' | f= functionName args= selectionFunctionArgs );
    public final RawSelector selector() throws RecognitionException {
        RawSelector s = null;

        ColumnIdentifier c = null;

        String f = null;

        List<RawSelector> args = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:246:5: (c= cident | K_WRITETIME '(' c= cident ')' | K_TTL '(' c= cident ')' | f= functionName args= selectionFunctionArgs )
            int alt13=4;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:246:7: c= cident
                    {
                    pushFollow(FOLLOW_cident_in_selector895);
                    c=cident();

                    state._fsp--;

                     s = c; 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:247:7: K_WRITETIME '(' c= cident ')'
                    {
                    match(input,K_WRITETIME,FOLLOW_K_WRITETIME_in_selector938); 
                    match(input,130,FOLLOW_130_in_selector940); 
                    pushFollow(FOLLOW_cident_in_selector944);
                    c=cident();

                    state._fsp--;

                    match(input,131,FOLLOW_131_in_selector946); 
                     s = new RawSelector.WritetimeOrTTL(c, true); 

                    }
                    break;
                case 3 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:248:7: K_TTL '(' c= cident ')'
                    {
                    match(input,K_TTL,FOLLOW_K_TTL_in_selector969); 
                    match(input,130,FOLLOW_130_in_selector977); 
                    pushFollow(FOLLOW_cident_in_selector981);
                    c=cident();

                    state._fsp--;

                    match(input,131,FOLLOW_131_in_selector983); 
                     s = new RawSelector.WritetimeOrTTL(c, false); 

                    }
                    break;
                case 4 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:249:7: f= functionName args= selectionFunctionArgs
                    {
                    pushFollow(FOLLOW_functionName_in_selector1008);
                    f=functionName();

                    state._fsp--;

                    pushFollow(FOLLOW_selectionFunctionArgs_in_selector1012);
                    args=selectionFunctionArgs();

                    state._fsp--;

                     s = new RawSelector.WithFunction(f, args); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "selector"


    // $ANTLR start "selectCountClause"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:252:1: selectCountClause returns [List<RawSelector> expr] : ( '\\*' | i= INTEGER );
    public final List<RawSelector> selectCountClause() throws RecognitionException {
        List<RawSelector> expr = null;

        Token i=null;

        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:253:5: ( '\\*' | i= INTEGER )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==133) ) {
                alt14=1;
            }
            else if ( (LA14_0==INTEGER) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:253:7: '\\*'
                    {
                    match(input,133,FOLLOW_133_in_selectCountClause1035); 
                     expr = Collections.<RawSelector>emptyList();

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:254:7: i= INTEGER
                    {
                    i=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_selectCountClause1057); 
                     if (!i.getText().equals("1")) addRecognitionError("Only COUNT(1) is supported, got COUNT(" + i.getText() + ")"); expr = Collections.<RawSelector>emptyList();

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "selectCountClause"


    // $ANTLR start "whereClause"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:257:1: whereClause returns [List<Relation> clause] : relation[$clause] ( K_AND relation[$clause] )* ;
    public final List<Relation> whereClause() throws RecognitionException {
        List<Relation> clause = null;

         clause = new ArrayList<Relation>(); 
        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:259:5: ( relation[$clause] ( K_AND relation[$clause] )* )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:259:7: relation[$clause] ( K_AND relation[$clause] )*
            {
            pushFollow(FOLLOW_relation_in_whereClause1093);
            relation(clause);

            state._fsp--;

            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:259:25: ( K_AND relation[$clause] )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==K_AND) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:259:26: K_AND relation[$clause]
            	    {
            	    match(input,K_AND,FOLLOW_K_AND_in_whereClause1097); 
            	    pushFollow(FOLLOW_relation_in_whereClause1099);
            	    relation(clause);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return clause;
    }
    // $ANTLR end "whereClause"


    // $ANTLR start "orderByClause"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:262:1: orderByClause[Map<ColumnIdentifier, Boolean> orderings] : c= cident ( K_ASC | K_DESC )? ;
    public final void orderByClause(Map<ColumnIdentifier, Boolean> orderings) throws RecognitionException {
        ColumnIdentifier c = null;



                ColumnIdentifier orderBy = null;
                boolean reversed = false;
            
        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:267:5: (c= cident ( K_ASC | K_DESC )? )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:267:7: c= cident ( K_ASC | K_DESC )?
            {
            pushFollow(FOLLOW_cident_in_orderByClause1130);
            c=cident();

            state._fsp--;

             orderBy = c; 
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:267:33: ( K_ASC | K_DESC )?
            int alt16=3;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==K_ASC) ) {
                alt16=1;
            }
            else if ( (LA16_0==K_DESC) ) {
                alt16=2;
            }
            switch (alt16) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:267:34: K_ASC
                    {
                    match(input,K_ASC,FOLLOW_K_ASC_in_orderByClause1135); 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:267:42: K_DESC
                    {
                    match(input,K_DESC,FOLLOW_K_DESC_in_orderByClause1139); 
                     reversed = true; 

                    }
                    break;

            }

             orderings.put(c, reversed); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "orderByClause"


    // $ANTLR start "insertStatement"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:270:1: insertStatement returns [UpdateStatement.ParsedInsert expr] : K_INSERT K_INTO cf= columnFamilyName '(' c1= cident ( ',' cn= cident )* ')' K_VALUES '(' v1= term ( ',' vn= term )* ')' ( usingClause[attrs] )? ;
    public final UpdateStatement.ParsedInsert insertStatement() throws RecognitionException {
        UpdateStatement.ParsedInsert expr = null;

        CFName cf = null;

        ColumnIdentifier c1 = null;

        ColumnIdentifier cn = null;

        Term.Raw v1 = null;

        Term.Raw vn = null;



                Attributes attrs = new Attributes();
                List<ColumnIdentifier> columnNames  = new ArrayList<ColumnIdentifier>();
                List<Term.Raw> values = new ArrayList<Term.Raw>();
            
        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:282:5: ( K_INSERT K_INTO cf= columnFamilyName '(' c1= cident ( ',' cn= cident )* ')' K_VALUES '(' v1= term ( ',' vn= term )* ')' ( usingClause[attrs] )? )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:282:7: K_INSERT K_INTO cf= columnFamilyName '(' c1= cident ( ',' cn= cident )* ')' K_VALUES '(' v1= term ( ',' vn= term )* ')' ( usingClause[attrs] )?
            {
            match(input,K_INSERT,FOLLOW_K_INSERT_in_insertStatement1177); 
            match(input,K_INTO,FOLLOW_K_INTO_in_insertStatement1179); 
            pushFollow(FOLLOW_columnFamilyName_in_insertStatement1183);
            cf=columnFamilyName();

            state._fsp--;

            match(input,130,FOLLOW_130_in_insertStatement1195); 
            pushFollow(FOLLOW_cident_in_insertStatement1199);
            c1=cident();

            state._fsp--;

             columnNames.add(c1); 
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:283:51: ( ',' cn= cident )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==132) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:283:53: ',' cn= cident
            	    {
            	    match(input,132,FOLLOW_132_in_insertStatement1206); 
            	    pushFollow(FOLLOW_cident_in_insertStatement1210);
            	    cn=cident();

            	    state._fsp--;

            	     columnNames.add(cn); 

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            match(input,131,FOLLOW_131_in_insertStatement1217); 
            match(input,K_VALUES,FOLLOW_K_VALUES_in_insertStatement1227); 
            match(input,130,FOLLOW_130_in_insertStatement1239); 
            pushFollow(FOLLOW_term_in_insertStatement1243);
            v1=term();

            state._fsp--;

             values.add(v1); 
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:285:43: ( ',' vn= term )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==132) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:285:45: ',' vn= term
            	    {
            	    match(input,132,FOLLOW_132_in_insertStatement1249); 
            	    pushFollow(FOLLOW_term_in_insertStatement1253);
            	    vn=term();

            	    state._fsp--;

            	     values.add(vn); 

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            match(input,131,FOLLOW_131_in_insertStatement1260); 
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:286:9: ( usingClause[attrs] )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==K_USING) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:286:11: usingClause[attrs]
                    {
                    pushFollow(FOLLOW_usingClause_in_insertStatement1272);
                    usingClause(attrs);

                    state._fsp--;


                    }
                    break;

            }


                      expr = new UpdateStatement.ParsedInsert(cf, attrs, columnNames, values);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "insertStatement"


    // $ANTLR start "usingClause"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:292:1: usingClause[Attributes attrs] : K_USING usingClauseObjective[attrs] ( ( K_AND )? usingClauseObjective[attrs] )* ;
    public final void usingClause(Attributes attrs) throws RecognitionException {
        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:293:5: ( K_USING usingClauseObjective[attrs] ( ( K_AND )? usingClauseObjective[attrs] )* )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:293:7: K_USING usingClauseObjective[attrs] ( ( K_AND )? usingClauseObjective[attrs] )*
            {
            match(input,K_USING,FOLLOW_K_USING_in_usingClause1302); 
            pushFollow(FOLLOW_usingClauseObjective_in_usingClause1304);
            usingClauseObjective(attrs);

            state._fsp--;

            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:293:43: ( ( K_AND )? usingClauseObjective[attrs] )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=K_TTL && LA21_0<=K_AND)||LA21_0==K_TIMESTAMP) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:293:45: ( K_AND )? usingClauseObjective[attrs]
            	    {
            	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:293:45: ( K_AND )?
            	    int alt20=2;
            	    int LA20_0 = input.LA(1);

            	    if ( (LA20_0==K_AND) ) {
            	        alt20=1;
            	    }
            	    switch (alt20) {
            	        case 1 :
            	            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:293:45: K_AND
            	            {
            	            match(input,K_AND,FOLLOW_K_AND_in_usingClause1309); 

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_usingClauseObjective_in_usingClause1312);
            	    usingClauseObjective(attrs);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "usingClause"


    // $ANTLR start "usingClauseDelete"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:296:1: usingClauseDelete[Attributes attrs] : K_USING usingClauseDeleteObjective[attrs] ( ( K_AND )? usingClauseDeleteObjective[attrs] )* ;
    public final void usingClauseDelete(Attributes attrs) throws RecognitionException {
        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:297:5: ( K_USING usingClauseDeleteObjective[attrs] ( ( K_AND )? usingClauseDeleteObjective[attrs] )* )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:297:7: K_USING usingClauseDeleteObjective[attrs] ( ( K_AND )? usingClauseDeleteObjective[attrs] )*
            {
            match(input,K_USING,FOLLOW_K_USING_in_usingClauseDelete1334); 
            pushFollow(FOLLOW_usingClauseDeleteObjective_in_usingClauseDelete1336);
            usingClauseDeleteObjective(attrs);

            state._fsp--;

            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:297:49: ( ( K_AND )? usingClauseDeleteObjective[attrs] )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==K_AND||LA23_0==K_TIMESTAMP) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:297:51: ( K_AND )? usingClauseDeleteObjective[attrs]
            	    {
            	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:297:51: ( K_AND )?
            	    int alt22=2;
            	    int LA22_0 = input.LA(1);

            	    if ( (LA22_0==K_AND) ) {
            	        alt22=1;
            	    }
            	    switch (alt22) {
            	        case 1 :
            	            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:297:51: K_AND
            	            {
            	            match(input,K_AND,FOLLOW_K_AND_in_usingClauseDelete1341); 

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_usingClauseDeleteObjective_in_usingClauseDelete1344);
            	    usingClauseDeleteObjective(attrs);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "usingClauseDelete"


    // $ANTLR start "usingClauseDeleteObjective"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:300:1: usingClauseDeleteObjective[Attributes attrs] : K_TIMESTAMP ts= INTEGER ;
    public final void usingClauseDeleteObjective(Attributes attrs) throws RecognitionException {
        Token ts=null;

        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:301:5: ( K_TIMESTAMP ts= INTEGER )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:301:7: K_TIMESTAMP ts= INTEGER
            {
            match(input,K_TIMESTAMP,FOLLOW_K_TIMESTAMP_in_usingClauseDeleteObjective1366); 
            ts=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_usingClauseDeleteObjective1370); 
             attrs.timestamp = Long.valueOf((ts!=null?ts.getText():null)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "usingClauseDeleteObjective"


    // $ANTLR start "usingClauseObjective"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:304:1: usingClauseObjective[Attributes attrs] : ( usingClauseDeleteObjective[attrs] | K_TTL t= INTEGER );
    public final void usingClauseObjective(Attributes attrs) throws RecognitionException {
        Token t=null;

        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:305:5: ( usingClauseDeleteObjective[attrs] | K_TTL t= INTEGER )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==K_TIMESTAMP) ) {
                alt24=1;
            }
            else if ( (LA24_0==K_TTL) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:305:7: usingClauseDeleteObjective[attrs]
                    {
                    pushFollow(FOLLOW_usingClauseDeleteObjective_in_usingClauseObjective1390);
                    usingClauseDeleteObjective(attrs);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:306:7: K_TTL t= INTEGER
                    {
                    match(input,K_TTL,FOLLOW_K_TTL_in_usingClauseObjective1399); 
                    t=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_usingClauseObjective1403); 
                     attrs.timeToLive = Integer.valueOf((t!=null?t.getText():null)); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "usingClauseObjective"


    // $ANTLR start "updateStatement"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:309:1: updateStatement returns [UpdateStatement.ParsedUpdate expr] : K_UPDATE cf= columnFamilyName ( usingClause[attrs] )? K_SET columnOperation[operations] ( ',' columnOperation[operations] )* K_WHERE wclause= whereClause ( K_IF ( K_NOT K_EXISTS | conditions= updateCondition ) )? ;
    public final UpdateStatement.ParsedUpdate updateStatement() throws RecognitionException {
        UpdateStatement.ParsedUpdate expr = null;

        CFName cf = null;

        List<Relation> wclause = null;

        List<Pair<ColumnIdentifier, Operation.RawUpdate>> conditions = null;



                Attributes attrs = new Attributes();
                List<Pair<ColumnIdentifier, Operation.RawUpdate>> operations = new ArrayList<Pair<ColumnIdentifier, Operation.RawUpdate>>();
                boolean ifNotExists = false;
            
        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:321:5: ( K_UPDATE cf= columnFamilyName ( usingClause[attrs] )? K_SET columnOperation[operations] ( ',' columnOperation[operations] )* K_WHERE wclause= whereClause ( K_IF ( K_NOT K_EXISTS | conditions= updateCondition ) )? )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:321:7: K_UPDATE cf= columnFamilyName ( usingClause[attrs] )? K_SET columnOperation[operations] ( ',' columnOperation[operations] )* K_WHERE wclause= whereClause ( K_IF ( K_NOT K_EXISTS | conditions= updateCondition ) )?
            {
            match(input,K_UPDATE,FOLLOW_K_UPDATE_in_updateStatement1437); 
            pushFollow(FOLLOW_columnFamilyName_in_updateStatement1441);
            cf=columnFamilyName();

            state._fsp--;

            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:322:7: ( usingClause[attrs] )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==K_USING) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:322:9: usingClause[attrs]
                    {
                    pushFollow(FOLLOW_usingClause_in_updateStatement1451);
                    usingClause(attrs);

                    state._fsp--;


                    }
                    break;

            }

            match(input,K_SET,FOLLOW_K_SET_in_updateStatement1463); 
            pushFollow(FOLLOW_columnOperation_in_updateStatement1465);
            columnOperation(operations);

            state._fsp--;

            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:323:41: ( ',' columnOperation[operations] )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==132) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:323:42: ',' columnOperation[operations]
            	    {
            	    match(input,132,FOLLOW_132_in_updateStatement1469); 
            	    pushFollow(FOLLOW_columnOperation_in_updateStatement1471);
            	    columnOperation(operations);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            match(input,K_WHERE,FOLLOW_K_WHERE_in_updateStatement1482); 
            pushFollow(FOLLOW_whereClause_in_updateStatement1486);
            wclause=whereClause();

            state._fsp--;

            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:325:7: ( K_IF ( K_NOT K_EXISTS | conditions= updateCondition ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==K_IF) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:325:9: K_IF ( K_NOT K_EXISTS | conditions= updateCondition )
                    {
                    match(input,K_IF,FOLLOW_K_IF_in_updateStatement1496); 
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:325:14: ( K_NOT K_EXISTS | conditions= updateCondition )
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==K_NOT) ) {
                        alt27=1;
                    }
                    else if ( (LA27_0==K_COUNT||(LA27_0>=K_FILTERING && LA27_0<=K_TTL)||LA27_0==K_VALUES||LA27_0==K_TIMESTAMP||LA27_0==K_EXISTS||LA27_0==K_COUNTER||(LA27_0>=K_KEY && LA27_0<=K_CLUSTERING)||LA27_0==IDENT||LA27_0==K_TYPE||LA27_0==K_LIST||(LA27_0>=K_ALL && LA27_0<=K_PASSWORD)||LA27_0==QUOTED_NAME||(LA27_0>=K_ASCII && LA27_0<=K_MAP)) ) {
                        alt27=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 27, 0, input);

                        throw nvae;
                    }
                    switch (alt27) {
                        case 1 :
                            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:325:15: K_NOT K_EXISTS
                            {
                            match(input,K_NOT,FOLLOW_K_NOT_in_updateStatement1499); 
                            match(input,K_EXISTS,FOLLOW_K_EXISTS_in_updateStatement1501); 
                             ifNotExists = true; 

                            }
                            break;
                        case 2 :
                            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:325:56: conditions= updateCondition
                            {
                            pushFollow(FOLLOW_updateCondition_in_updateStatement1509);
                            conditions=updateCondition();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;

            }


                      return new UpdateStatement.ParsedUpdate(cf,
                                                              attrs,
                                                              operations,
                                                              wclause,
                                                              conditions == null ? Collections.<Pair<ColumnIdentifier, Operation.RawUpdate>>emptyList() : conditions,
                                                              ifNotExists);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "updateStatement"


    // $ANTLR start "updateCondition"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:336:1: updateCondition returns [List<Pair<ColumnIdentifier, Operation.RawUpdate>> conditions] : columnOperation[conditions] ( K_AND columnOperation[conditions] )* ;
    public final List<Pair<ColumnIdentifier, Operation.RawUpdate>> updateCondition() throws RecognitionException {
        List<Pair<ColumnIdentifier, Operation.RawUpdate>> conditions = null;

         conditions = new ArrayList<Pair<ColumnIdentifier, Operation.RawUpdate>>(); 
        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:338:5: ( columnOperation[conditions] ( K_AND columnOperation[conditions] )* )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:338:7: columnOperation[conditions] ( K_AND columnOperation[conditions] )*
            {
            pushFollow(FOLLOW_columnOperation_in_updateCondition1551);
            columnOperation(conditions);

            state._fsp--;

            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:338:35: ( K_AND columnOperation[conditions] )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==K_AND) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:338:37: K_AND columnOperation[conditions]
            	    {
            	    match(input,K_AND,FOLLOW_K_AND_in_updateCondition1556); 
            	    pushFollow(FOLLOW_columnOperation_in_updateCondition1558);
            	    columnOperation(conditions);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return conditions;
    }
    // $ANTLR end "updateCondition"


    // $ANTLR start "deleteStatement"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:341:1: deleteStatement returns [DeleteStatement.Parsed expr] : K_DELETE (dels= deleteSelection )? K_FROM cf= columnFamilyName ( usingClauseDelete[attrs] )? K_WHERE wclause= whereClause ( K_IF conditions= updateCondition )? ;
    public final DeleteStatement.Parsed deleteStatement() throws RecognitionException {
        DeleteStatement.Parsed expr = null;

        List<Operation.RawDeletion> dels = null;

        CFName cf = null;

        List<Relation> wclause = null;

        List<Pair<ColumnIdentifier, Operation.RawUpdate>> conditions = null;



                Attributes attrs = new Attributes();
                List<Operation.RawDeletion> columnDeletions = Collections.emptyList();
            
        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:352:5: ( K_DELETE (dels= deleteSelection )? K_FROM cf= columnFamilyName ( usingClauseDelete[attrs] )? K_WHERE wclause= whereClause ( K_IF conditions= updateCondition )? )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:352:7: K_DELETE (dels= deleteSelection )? K_FROM cf= columnFamilyName ( usingClauseDelete[attrs] )? K_WHERE wclause= whereClause ( K_IF conditions= updateCondition )?
            {
            match(input,K_DELETE,FOLLOW_K_DELETE_in_deleteStatement1594); 
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:352:16: (dels= deleteSelection )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==K_COUNT||(LA30_0>=K_FILTERING && LA30_0<=K_TTL)||LA30_0==K_VALUES||LA30_0==K_TIMESTAMP||LA30_0==K_EXISTS||LA30_0==K_COUNTER||(LA30_0>=K_KEY && LA30_0<=K_CLUSTERING)||LA30_0==IDENT||LA30_0==K_TYPE||LA30_0==K_LIST||(LA30_0>=K_ALL && LA30_0<=K_PASSWORD)||LA30_0==QUOTED_NAME||(LA30_0>=K_ASCII && LA30_0<=K_MAP)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:352:18: dels= deleteSelection
                    {
                    pushFollow(FOLLOW_deleteSelection_in_deleteStatement1600);
                    dels=deleteSelection();

                    state._fsp--;

                     columnDeletions = dels; 

                    }
                    break;

            }

            match(input,K_FROM,FOLLOW_K_FROM_in_deleteStatement1613); 
            pushFollow(FOLLOW_columnFamilyName_in_deleteStatement1617);
            cf=columnFamilyName();

            state._fsp--;

            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:354:7: ( usingClauseDelete[attrs] )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==K_USING) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:354:9: usingClauseDelete[attrs]
                    {
                    pushFollow(FOLLOW_usingClauseDelete_in_deleteStatement1627);
                    usingClauseDelete(attrs);

                    state._fsp--;


                    }
                    break;

            }

            match(input,K_WHERE,FOLLOW_K_WHERE_in_deleteStatement1639); 
            pushFollow(FOLLOW_whereClause_in_deleteStatement1643);
            wclause=whereClause();

            state._fsp--;

            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:356:7: ( K_IF conditions= updateCondition )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==K_IF) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:356:9: K_IF conditions= updateCondition
                    {
                    match(input,K_IF,FOLLOW_K_IF_in_deleteStatement1653); 
                    pushFollow(FOLLOW_updateCondition_in_deleteStatement1657);
                    conditions=updateCondition();

                    state._fsp--;


                    }
                    break;

            }


                      return new DeleteStatement.Parsed(cf,
                                                        attrs,
                                                        columnDeletions,
                                                        wclause,
                                                        conditions == null ? Collections.<Pair<ColumnIdentifier, Operation.RawUpdate>>emptyList() : conditions);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "deleteStatement"


    // $ANTLR start "deleteSelection"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:366:1: deleteSelection returns [List<Operation.RawDeletion> operations] : t1= deleteOp ( ',' tN= deleteOp )* ;
    public final List<Operation.RawDeletion> deleteSelection() throws RecognitionException {
        List<Operation.RawDeletion> operations = null;

        Operation.RawDeletion t1 = null;

        Operation.RawDeletion tN = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:367:5: (t1= deleteOp ( ',' tN= deleteOp )* )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:367:7: t1= deleteOp ( ',' tN= deleteOp )*
            {
             operations = new ArrayList<Operation.RawDeletion>(); 
            pushFollow(FOLLOW_deleteOp_in_deleteSelection1703);
            t1=deleteOp();

            state._fsp--;

             operations.add(t1); 
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:369:11: ( ',' tN= deleteOp )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==132) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:369:12: ',' tN= deleteOp
            	    {
            	    match(input,132,FOLLOW_132_in_deleteSelection1718); 
            	    pushFollow(FOLLOW_deleteOp_in_deleteSelection1722);
            	    tN=deleteOp();

            	    state._fsp--;

            	     operations.add(tN); 

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return operations;
    }
    // $ANTLR end "deleteSelection"


    // $ANTLR start "deleteOp"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:372:1: deleteOp returns [Operation.RawDeletion op] : (c= cident | c= cident '[' t= term ']' );
    public final Operation.RawDeletion deleteOp() throws RecognitionException {
        Operation.RawDeletion op = null;

        ColumnIdentifier c = null;

        Term.Raw t = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:373:5: (c= cident | c= cident '[' t= term ']' )
            int alt34=2;
            alt34 = dfa34.predict(input);
            switch (alt34) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:373:7: c= cident
                    {
                    pushFollow(FOLLOW_cident_in_deleteOp1749);
                    c=cident();

                    state._fsp--;

                     op = new Operation.ColumnDeletion(c); 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:374:7: c= cident '[' t= term ']'
                    {
                    pushFollow(FOLLOW_cident_in_deleteOp1776);
                    c=cident();

                    state._fsp--;

                    match(input,134,FOLLOW_134_in_deleteOp1778); 
                    pushFollow(FOLLOW_term_in_deleteOp1782);
                    t=term();

                    state._fsp--;

                    match(input,135,FOLLOW_135_in_deleteOp1784); 
                     op = new Operation.ElementDeletion(c, t); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return op;
    }
    // $ANTLR end "deleteOp"


    // $ANTLR start "batchStatement"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:377:1: batchStatement returns [BatchStatement.Parsed expr] : K_BEGIN ( K_UNLOGGED | K_COUNTER )? K_BATCH ( usingClause[attrs] )? s1= batchStatementObjective ( ';' )? (sN= batchStatementObjective ( ';' )? )* K_APPLY K_BATCH ;
    public final BatchStatement.Parsed batchStatement() throws RecognitionException {
        BatchStatement.Parsed expr = null;

        ModificationStatement.Parsed s1 = null;

        ModificationStatement.Parsed sN = null;



                BatchStatement.Type type = BatchStatement.Type.LOGGED;
                List<ModificationStatement.Parsed> statements = new ArrayList<ModificationStatement.Parsed>();
                Attributes attrs = new Attributes();
            
        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:407:5: ( K_BEGIN ( K_UNLOGGED | K_COUNTER )? K_BATCH ( usingClause[attrs] )? s1= batchStatementObjective ( ';' )? (sN= batchStatementObjective ( ';' )? )* K_APPLY K_BATCH )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:407:7: K_BEGIN ( K_UNLOGGED | K_COUNTER )? K_BATCH ( usingClause[attrs] )? s1= batchStatementObjective ( ';' )? (sN= batchStatementObjective ( ';' )? )* K_APPLY K_BATCH
            {
            match(input,K_BEGIN,FOLLOW_K_BEGIN_in_batchStatement1818); 
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:408:7: ( K_UNLOGGED | K_COUNTER )?
            int alt35=3;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==K_UNLOGGED) ) {
                alt35=1;
            }
            else if ( (LA35_0==K_COUNTER) ) {
                alt35=2;
            }
            switch (alt35) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:408:9: K_UNLOGGED
                    {
                    match(input,K_UNLOGGED,FOLLOW_K_UNLOGGED_in_batchStatement1828); 
                     type = BatchStatement.Type.UNLOGGED; 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:408:63: K_COUNTER
                    {
                    match(input,K_COUNTER,FOLLOW_K_COUNTER_in_batchStatement1834); 
                     type = BatchStatement.Type.COUNTER; 

                    }
                    break;

            }

            match(input,K_BATCH,FOLLOW_K_BATCH_in_batchStatement1847); 
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:409:15: ( usingClause[attrs] )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==K_USING) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:409:17: usingClause[attrs]
                    {
                    pushFollow(FOLLOW_usingClause_in_batchStatement1851);
                    usingClause(attrs);

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_batchStatementObjective_in_batchStatement1869);
            s1=batchStatementObjective();

            state._fsp--;

            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:410:38: ( ';' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==129) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:410:38: ';'
                    {
                    match(input,129,FOLLOW_129_in_batchStatement1871); 

                    }
                    break;

            }

             statements.add(s1); 
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:410:67: (sN= batchStatementObjective ( ';' )? )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==K_INSERT||LA39_0==K_UPDATE||LA39_0==K_DELETE) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:410:69: sN= batchStatementObjective ( ';' )?
            	    {
            	    pushFollow(FOLLOW_batchStatementObjective_in_batchStatement1880);
            	    sN=batchStatementObjective();

            	    state._fsp--;

            	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:410:96: ( ';' )?
            	    int alt38=2;
            	    int LA38_0 = input.LA(1);

            	    if ( (LA38_0==129) ) {
            	        alt38=1;
            	    }
            	    switch (alt38) {
            	        case 1 :
            	            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:410:96: ';'
            	            {
            	            match(input,129,FOLLOW_129_in_batchStatement1882); 

            	            }
            	            break;

            	    }

            	     statements.add(sN); 

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

            match(input,K_APPLY,FOLLOW_K_APPLY_in_batchStatement1896); 
            match(input,K_BATCH,FOLLOW_K_BATCH_in_batchStatement1898); 

                      return new BatchStatement.Parsed(type, attrs, statements);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "batchStatement"


    // $ANTLR start "batchStatementObjective"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:417:1: batchStatementObjective returns [ModificationStatement.Parsed statement] : (i= insertStatement | u= updateStatement | d= deleteStatement );
    public final ModificationStatement.Parsed batchStatementObjective() throws RecognitionException {
        ModificationStatement.Parsed statement = null;

        UpdateStatement.ParsedInsert i = null;

        UpdateStatement.ParsedUpdate u = null;

        DeleteStatement.Parsed d = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:418:5: (i= insertStatement | u= updateStatement | d= deleteStatement )
            int alt40=3;
            switch ( input.LA(1) ) {
            case K_INSERT:
                {
                alt40=1;
                }
                break;
            case K_UPDATE:
                {
                alt40=2;
                }
                break;
            case K_DELETE:
                {
                alt40=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:418:7: i= insertStatement
                    {
                    pushFollow(FOLLOW_insertStatement_in_batchStatementObjective1929);
                    i=insertStatement();

                    state._fsp--;

                     statement = i; 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:419:7: u= updateStatement
                    {
                    pushFollow(FOLLOW_updateStatement_in_batchStatementObjective1942);
                    u=updateStatement();

                    state._fsp--;

                     statement = u; 

                    }
                    break;
                case 3 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:420:7: d= deleteStatement
                    {
                    pushFollow(FOLLOW_deleteStatement_in_batchStatementObjective1955);
                    d=deleteStatement();

                    state._fsp--;

                     statement = d; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return statement;
    }
    // $ANTLR end "batchStatementObjective"


    // $ANTLR start "createKeyspaceStatement"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:423:1: createKeyspaceStatement returns [CreateKeyspaceStatement expr] : K_CREATE K_KEYSPACE ks= keyspaceName K_WITH properties[attrs] ;
    public final CreateKeyspaceStatement createKeyspaceStatement() throws RecognitionException {
        CreateKeyspaceStatement expr = null;

        String ks = null;


         KSPropDefs attrs = new KSPropDefs(); 
        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:428:5: ( K_CREATE K_KEYSPACE ks= keyspaceName K_WITH properties[attrs] )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:428:7: K_CREATE K_KEYSPACE ks= keyspaceName K_WITH properties[attrs]
            {
            match(input,K_CREATE,FOLLOW_K_CREATE_in_createKeyspaceStatement1990); 
            match(input,K_KEYSPACE,FOLLOW_K_KEYSPACE_in_createKeyspaceStatement1992); 
            pushFollow(FOLLOW_keyspaceName_in_createKeyspaceStatement1996);
            ks=keyspaceName();

            state._fsp--;

            match(input,K_WITH,FOLLOW_K_WITH_in_createKeyspaceStatement2004); 
            pushFollow(FOLLOW_properties_in_createKeyspaceStatement2006);
            properties(attrs);

            state._fsp--;

             expr = new CreateKeyspaceStatement(ks, attrs); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "createKeyspaceStatement"


    // $ANTLR start "createColumnFamilyStatement"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:432:1: createColumnFamilyStatement returns [CreateColumnFamilyStatement.RawStatement expr] : K_CREATE K_COLUMNFAMILY cf= columnFamilyName cfamDefinition[expr] ;
    public final CreateColumnFamilyStatement.RawStatement createColumnFamilyStatement() throws RecognitionException {
        CreateColumnFamilyStatement.RawStatement expr = null;

        CFName cf = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:440:5: ( K_CREATE K_COLUMNFAMILY cf= columnFamilyName cfamDefinition[expr] )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:440:7: K_CREATE K_COLUMNFAMILY cf= columnFamilyName cfamDefinition[expr]
            {
            match(input,K_CREATE,FOLLOW_K_CREATE_in_createColumnFamilyStatement2032); 
            match(input,K_COLUMNFAMILY,FOLLOW_K_COLUMNFAMILY_in_createColumnFamilyStatement2034); 
            pushFollow(FOLLOW_columnFamilyName_in_createColumnFamilyStatement2038);
            cf=columnFamilyName();

            state._fsp--;

             expr = new CreateColumnFamilyStatement.RawStatement(cf); 
            pushFollow(FOLLOW_cfamDefinition_in_createColumnFamilyStatement2048);
            cfamDefinition(expr);

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "createColumnFamilyStatement"


    // $ANTLR start "cfamDefinition"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:444:1: cfamDefinition[CreateColumnFamilyStatement.RawStatement expr] : '(' cfamColumns[expr] ( ',' ( cfamColumns[expr] )? )* ')' ( K_WITH cfamProperty[expr] ( K_AND cfamProperty[expr] )* )? ;
    public final void cfamDefinition(CreateColumnFamilyStatement.RawStatement expr) throws RecognitionException {
        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:445:5: ( '(' cfamColumns[expr] ( ',' ( cfamColumns[expr] )? )* ')' ( K_WITH cfamProperty[expr] ( K_AND cfamProperty[expr] )* )? )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:445:7: '(' cfamColumns[expr] ( ',' ( cfamColumns[expr] )? )* ')' ( K_WITH cfamProperty[expr] ( K_AND cfamProperty[expr] )* )?
            {
            match(input,130,FOLLOW_130_in_cfamDefinition2067); 
            pushFollow(FOLLOW_cfamColumns_in_cfamDefinition2069);
            cfamColumns(expr);

            state._fsp--;

            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:445:29: ( ',' ( cfamColumns[expr] )? )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==132) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:445:31: ',' ( cfamColumns[expr] )?
            	    {
            	    match(input,132,FOLLOW_132_in_cfamDefinition2074); 
            	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:445:35: ( cfamColumns[expr] )?
            	    int alt41=2;
            	    int LA41_0 = input.LA(1);

            	    if ( (LA41_0==K_COUNT||(LA41_0>=K_FILTERING && LA41_0<=K_TTL)||LA41_0==K_VALUES||LA41_0==K_TIMESTAMP||LA41_0==K_EXISTS||LA41_0==K_COUNTER||(LA41_0>=K_PRIMARY && LA41_0<=K_CLUSTERING)||LA41_0==IDENT||LA41_0==K_TYPE||LA41_0==K_LIST||(LA41_0>=K_ALL && LA41_0<=K_PASSWORD)||LA41_0==QUOTED_NAME||(LA41_0>=K_ASCII && LA41_0<=K_MAP)) ) {
            	        alt41=1;
            	    }
            	    switch (alt41) {
            	        case 1 :
            	            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:445:35: cfamColumns[expr]
            	            {
            	            pushFollow(FOLLOW_cfamColumns_in_cfamDefinition2076);
            	            cfamColumns(expr);

            	            state._fsp--;


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            match(input,131,FOLLOW_131_in_cfamDefinition2083); 
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:446:7: ( K_WITH cfamProperty[expr] ( K_AND cfamProperty[expr] )* )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==K_WITH) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:446:9: K_WITH cfamProperty[expr] ( K_AND cfamProperty[expr] )*
                    {
                    match(input,K_WITH,FOLLOW_K_WITH_in_cfamDefinition2093); 
                    pushFollow(FOLLOW_cfamProperty_in_cfamDefinition2095);
                    cfamProperty(expr);

                    state._fsp--;

                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:446:35: ( K_AND cfamProperty[expr] )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==K_AND) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:446:37: K_AND cfamProperty[expr]
                    	    {
                    	    match(input,K_AND,FOLLOW_K_AND_in_cfamDefinition2100); 
                    	    pushFollow(FOLLOW_cfamProperty_in_cfamDefinition2102);
                    	    cfamProperty(expr);

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "cfamDefinition"


    // $ANTLR start "cfamColumns"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:449:1: cfamColumns[CreateColumnFamilyStatement.RawStatement expr] : (k= cident v= comparatorType ( K_PRIMARY K_KEY )? | K_PRIMARY K_KEY '(' pkDef[expr] ( ',' c= cident )* ')' );
    public final void cfamColumns(CreateColumnFamilyStatement.RawStatement expr) throws RecognitionException {
        ColumnIdentifier k = null;

        CQL3Type v = null;

        ColumnIdentifier c = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:450:5: (k= cident v= comparatorType ( K_PRIMARY K_KEY )? | K_PRIMARY K_KEY '(' pkDef[expr] ( ',' c= cident )* ')' )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==K_COUNT||(LA47_0>=K_FILTERING && LA47_0<=K_TTL)||LA47_0==K_VALUES||LA47_0==K_TIMESTAMP||LA47_0==K_EXISTS||LA47_0==K_COUNTER||(LA47_0>=K_KEY && LA47_0<=K_CLUSTERING)||LA47_0==IDENT||LA47_0==K_TYPE||LA47_0==K_LIST||(LA47_0>=K_ALL && LA47_0<=K_PASSWORD)||LA47_0==QUOTED_NAME||(LA47_0>=K_ASCII && LA47_0<=K_MAP)) ) {
                alt47=1;
            }
            else if ( (LA47_0==K_PRIMARY) ) {
                alt47=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:450:7: k= cident v= comparatorType ( K_PRIMARY K_KEY )?
                    {
                    pushFollow(FOLLOW_cident_in_cfamColumns2128);
                    k=cident();

                    state._fsp--;

                    pushFollow(FOLLOW_comparatorType_in_cfamColumns2132);
                    v=comparatorType();

                    state._fsp--;

                     expr.addDefinition(k, v); 
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:450:64: ( K_PRIMARY K_KEY )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==K_PRIMARY) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:450:65: K_PRIMARY K_KEY
                            {
                            match(input,K_PRIMARY,FOLLOW_K_PRIMARY_in_cfamColumns2137); 
                            match(input,K_KEY,FOLLOW_K_KEY_in_cfamColumns2139); 
                             expr.addKeyAliases(Collections.singletonList(k)); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:451:7: K_PRIMARY K_KEY '(' pkDef[expr] ( ',' c= cident )* ')'
                    {
                    match(input,K_PRIMARY,FOLLOW_K_PRIMARY_in_cfamColumns2151); 
                    match(input,K_KEY,FOLLOW_K_KEY_in_cfamColumns2153); 
                    match(input,130,FOLLOW_130_in_cfamColumns2155); 
                    pushFollow(FOLLOW_pkDef_in_cfamColumns2157);
                    pkDef(expr);

                    state._fsp--;

                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:451:39: ( ',' c= cident )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==132) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:451:40: ',' c= cident
                    	    {
                    	    match(input,132,FOLLOW_132_in_cfamColumns2161); 
                    	    pushFollow(FOLLOW_cident_in_cfamColumns2165);
                    	    c=cident();

                    	    state._fsp--;

                    	     expr.addColumnAlias(c); 

                    	    }
                    	    break;

                    	default :
                    	    break loop46;
                        }
                    } while (true);

                    match(input,131,FOLLOW_131_in_cfamColumns2172); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "cfamColumns"


    // $ANTLR start "pkDef"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:454:1: pkDef[CreateColumnFamilyStatement.RawStatement expr] : (k= cident | '(' k1= cident ( ',' kn= cident )* ')' );
    public final void pkDef(CreateColumnFamilyStatement.RawStatement expr) throws RecognitionException {
        ColumnIdentifier k = null;

        ColumnIdentifier k1 = null;

        ColumnIdentifier kn = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:455:5: (k= cident | '(' k1= cident ( ',' kn= cident )* ')' )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==K_COUNT||(LA49_0>=K_FILTERING && LA49_0<=K_TTL)||LA49_0==K_VALUES||LA49_0==K_TIMESTAMP||LA49_0==K_EXISTS||LA49_0==K_COUNTER||(LA49_0>=K_KEY && LA49_0<=K_CLUSTERING)||LA49_0==IDENT||LA49_0==K_TYPE||LA49_0==K_LIST||(LA49_0>=K_ALL && LA49_0<=K_PASSWORD)||LA49_0==QUOTED_NAME||(LA49_0>=K_ASCII && LA49_0<=K_MAP)) ) {
                alt49=1;
            }
            else if ( (LA49_0==130) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:455:7: k= cident
                    {
                    pushFollow(FOLLOW_cident_in_pkDef2192);
                    k=cident();

                    state._fsp--;

                     expr.addKeyAliases(Collections.singletonList(k)); 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:456:7: '(' k1= cident ( ',' kn= cident )* ')'
                    {
                    match(input,130,FOLLOW_130_in_pkDef2202); 
                     List<ColumnIdentifier> l = new ArrayList<ColumnIdentifier>(); 
                    pushFollow(FOLLOW_cident_in_pkDef2208);
                    k1=cident();

                    state._fsp--;

                     l.add(k1); 
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:456:102: ( ',' kn= cident )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==132) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:456:104: ',' kn= cident
                    	    {
                    	    match(input,132,FOLLOW_132_in_pkDef2214); 
                    	    pushFollow(FOLLOW_cident_in_pkDef2218);
                    	    kn=cident();

                    	    state._fsp--;

                    	     l.add(kn); 

                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);

                    match(input,131,FOLLOW_131_in_pkDef2225); 
                     expr.addKeyAliases(l); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "pkDef"


    // $ANTLR start "cfamProperty"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:459:1: cfamProperty[CreateColumnFamilyStatement.RawStatement expr] : ( property[expr.properties] | K_COMPACT K_STORAGE | K_CLUSTERING K_ORDER K_BY '(' cfamOrdering[expr] ( ',' cfamOrdering[expr] )* ')' );
    public final void cfamProperty(CreateColumnFamilyStatement.RawStatement expr) throws RecognitionException {
        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:460:5: ( property[expr.properties] | K_COMPACT K_STORAGE | K_CLUSTERING K_ORDER K_BY '(' cfamOrdering[expr] ( ',' cfamOrdering[expr] )* ')' )
            int alt51=3;
            switch ( input.LA(1) ) {
            case K_COUNT:
            case K_FILTERING:
            case K_WRITETIME:
            case K_TTL:
            case K_VALUES:
            case K_TIMESTAMP:
            case K_EXISTS:
            case K_COUNTER:
            case K_KEY:
            case K_STORAGE:
            case IDENT:
            case K_TYPE:
            case K_LIST:
            case K_ALL:
            case K_PERMISSIONS:
            case K_PERMISSION:
            case K_KEYSPACES:
            case K_USER:
            case K_SUPERUSER:
            case K_NOSUPERUSER:
            case K_USERS:
            case K_PASSWORD:
            case QUOTED_NAME:
            case K_ASCII:
            case K_BIGINT:
            case K_BLOB:
            case K_BOOLEAN:
            case K_DECIMAL:
            case K_DOUBLE:
            case K_FLOAT:
            case K_INET:
            case K_INT:
            case K_TEXT:
            case K_UUID:
            case K_VARCHAR:
            case K_VARINT:
            case K_TIMEUUID:
            case K_MAP:
                {
                alt51=1;
                }
                break;
            case K_COMPACT:
                {
                int LA51_2 = input.LA(2);

                if ( (LA51_2==K_STORAGE) ) {
                    alt51=2;
                }
                else if ( (LA51_2==140) ) {
                    alt51=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 51, 2, input);

                    throw nvae;
                }
                }
                break;
            case K_CLUSTERING:
                {
                int LA51_3 = input.LA(2);

                if ( (LA51_3==K_ORDER) ) {
                    alt51=3;
                }
                else if ( (LA51_3==140) ) {
                    alt51=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 51, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:460:7: property[expr.properties]
                    {
                    pushFollow(FOLLOW_property_in_cfamProperty2245);
                    property(expr.properties);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:461:7: K_COMPACT K_STORAGE
                    {
                    match(input,K_COMPACT,FOLLOW_K_COMPACT_in_cfamProperty2254); 
                    match(input,K_STORAGE,FOLLOW_K_STORAGE_in_cfamProperty2256); 
                     expr.setCompactStorage(); 

                    }
                    break;
                case 3 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:462:7: K_CLUSTERING K_ORDER K_BY '(' cfamOrdering[expr] ( ',' cfamOrdering[expr] )* ')'
                    {
                    match(input,K_CLUSTERING,FOLLOW_K_CLUSTERING_in_cfamProperty2266); 
                    match(input,K_ORDER,FOLLOW_K_ORDER_in_cfamProperty2268); 
                    match(input,K_BY,FOLLOW_K_BY_in_cfamProperty2270); 
                    match(input,130,FOLLOW_130_in_cfamProperty2272); 
                    pushFollow(FOLLOW_cfamOrdering_in_cfamProperty2274);
                    cfamOrdering(expr);

                    state._fsp--;

                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:462:56: ( ',' cfamOrdering[expr] )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==132) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:462:57: ',' cfamOrdering[expr]
                    	    {
                    	    match(input,132,FOLLOW_132_in_cfamProperty2278); 
                    	    pushFollow(FOLLOW_cfamOrdering_in_cfamProperty2280);
                    	    cfamOrdering(expr);

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop50;
                        }
                    } while (true);

                    match(input,131,FOLLOW_131_in_cfamProperty2285); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "cfamProperty"


    // $ANTLR start "cfamOrdering"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:465:1: cfamOrdering[CreateColumnFamilyStatement.RawStatement expr] : k= cident ( K_ASC | K_DESC ) ;
    public final void cfamOrdering(CreateColumnFamilyStatement.RawStatement expr) throws RecognitionException {
        ColumnIdentifier k = null;


         boolean reversed=false; 
        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:467:5: (k= cident ( K_ASC | K_DESC ) )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:467:7: k= cident ( K_ASC | K_DESC )
            {
            pushFollow(FOLLOW_cident_in_cfamOrdering2313);
            k=cident();

            state._fsp--;

            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:467:16: ( K_ASC | K_DESC )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==K_ASC) ) {
                alt52=1;
            }
            else if ( (LA52_0==K_DESC) ) {
                alt52=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:467:17: K_ASC
                    {
                    match(input,K_ASC,FOLLOW_K_ASC_in_cfamOrdering2316); 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:467:25: K_DESC
                    {
                    match(input,K_DESC,FOLLOW_K_DESC_in_cfamOrdering2320); 
                     reversed=true;

                    }
                    break;

            }

             expr.setOrdering(k, reversed); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "cfamOrdering"


    // $ANTLR start "createIndexStatement"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:470:1: createIndexStatement returns [CreateIndexStatement expr] : K_CREATE K_INDEX (idxName= IDENT )? K_ON cf= columnFamilyName '(' id= cident ')' ;
    public final CreateIndexStatement createIndexStatement() throws RecognitionException {
        CreateIndexStatement expr = null;

        Token idxName=null;
        CFName cf = null;

        ColumnIdentifier id = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:474:5: ( K_CREATE K_INDEX (idxName= IDENT )? K_ON cf= columnFamilyName '(' id= cident ')' )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:474:7: K_CREATE K_INDEX (idxName= IDENT )? K_ON cf= columnFamilyName '(' id= cident ')'
            {
            match(input,K_CREATE,FOLLOW_K_CREATE_in_createIndexStatement2349); 
            match(input,K_INDEX,FOLLOW_K_INDEX_in_createIndexStatement2351); 
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:474:24: (idxName= IDENT )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==IDENT) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:474:25: idxName= IDENT
                    {
                    idxName=(Token)match(input,IDENT,FOLLOW_IDENT_in_createIndexStatement2356); 

                    }
                    break;

            }

            match(input,K_ON,FOLLOW_K_ON_in_createIndexStatement2360); 
            pushFollow(FOLLOW_columnFamilyName_in_createIndexStatement2364);
            cf=columnFamilyName();

            state._fsp--;

            match(input,130,FOLLOW_130_in_createIndexStatement2366); 
            pushFollow(FOLLOW_cident_in_createIndexStatement2370);
            id=cident();

            state._fsp--;

            match(input,131,FOLLOW_131_in_createIndexStatement2372); 
             expr = new CreateIndexStatement(cf, (idxName!=null?idxName.getText():null), id); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "createIndexStatement"


    // $ANTLR start "alterKeyspaceStatement"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:478:1: alterKeyspaceStatement returns [AlterKeyspaceStatement expr] : K_ALTER K_KEYSPACE ks= keyspaceName K_WITH properties[attrs] ;
    public final AlterKeyspaceStatement alterKeyspaceStatement() throws RecognitionException {
        AlterKeyspaceStatement expr = null;

        String ks = null;


         KSPropDefs attrs = new KSPropDefs(); 
        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:483:5: ( K_ALTER K_KEYSPACE ks= keyspaceName K_WITH properties[attrs] )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:483:7: K_ALTER K_KEYSPACE ks= keyspaceName K_WITH properties[attrs]
            {
            match(input,K_ALTER,FOLLOW_K_ALTER_in_alterKeyspaceStatement2412); 
            match(input,K_KEYSPACE,FOLLOW_K_KEYSPACE_in_alterKeyspaceStatement2414); 
            pushFollow(FOLLOW_keyspaceName_in_alterKeyspaceStatement2418);
            ks=keyspaceName();

            state._fsp--;

            match(input,K_WITH,FOLLOW_K_WITH_in_alterKeyspaceStatement2428); 
            pushFollow(FOLLOW_properties_in_alterKeyspaceStatement2430);
            properties(attrs);

            state._fsp--;

             expr = new AlterKeyspaceStatement(ks, attrs); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "alterKeyspaceStatement"


    // $ANTLR start "alterTableStatement"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:488:1: alterTableStatement returns [AlterTableStatement expr] : K_ALTER K_COLUMNFAMILY cf= columnFamilyName ( K_ALTER id= cident K_TYPE v= comparatorType | K_ADD id= cident v= comparatorType | K_DROP id= cident | K_WITH properties[props] | K_RENAME id1= cident K_TO toId1= cident ( K_AND idn= cident K_TO toIdn= cident )* ) ;
    public final AlterTableStatement alterTableStatement() throws RecognitionException {
        AlterTableStatement expr = null;

        CFName cf = null;

        ColumnIdentifier id = null;

        CQL3Type v = null;

        ColumnIdentifier id1 = null;

        ColumnIdentifier toId1 = null;

        ColumnIdentifier idn = null;

        ColumnIdentifier toIdn = null;



                AlterTableStatement.Type type = null;
                CFPropDefs props = new CFPropDefs();
                Map<ColumnIdentifier, ColumnIdentifier> renames = new HashMap<ColumnIdentifier, ColumnIdentifier>();
            
        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:501:5: ( K_ALTER K_COLUMNFAMILY cf= columnFamilyName ( K_ALTER id= cident K_TYPE v= comparatorType | K_ADD id= cident v= comparatorType | K_DROP id= cident | K_WITH properties[props] | K_RENAME id1= cident K_TO toId1= cident ( K_AND idn= cident K_TO toIdn= cident )* ) )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:501:7: K_ALTER K_COLUMNFAMILY cf= columnFamilyName ( K_ALTER id= cident K_TYPE v= comparatorType | K_ADD id= cident v= comparatorType | K_DROP id= cident | K_WITH properties[props] | K_RENAME id1= cident K_TO toId1= cident ( K_AND idn= cident K_TO toIdn= cident )* )
            {
            match(input,K_ALTER,FOLLOW_K_ALTER_in_alterTableStatement2466); 
            match(input,K_COLUMNFAMILY,FOLLOW_K_COLUMNFAMILY_in_alterTableStatement2468); 
            pushFollow(FOLLOW_columnFamilyName_in_alterTableStatement2472);
            cf=columnFamilyName();

            state._fsp--;

            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:502:11: ( K_ALTER id= cident K_TYPE v= comparatorType | K_ADD id= cident v= comparatorType | K_DROP id= cident | K_WITH properties[props] | K_RENAME id1= cident K_TO toId1= cident ( K_AND idn= cident K_TO toIdn= cident )* )
            int alt55=5;
            switch ( input.LA(1) ) {
            case K_ALTER:
                {
                alt55=1;
                }
                break;
            case K_ADD:
                {
                alt55=2;
                }
                break;
            case K_DROP:
                {
                alt55=3;
                }
                break;
            case K_WITH:
                {
                alt55=4;
                }
                break;
            case K_RENAME:
                {
                alt55=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:502:13: K_ALTER id= cident K_TYPE v= comparatorType
                    {
                    match(input,K_ALTER,FOLLOW_K_ALTER_in_alterTableStatement2486); 
                    pushFollow(FOLLOW_cident_in_alterTableStatement2490);
                    id=cident();

                    state._fsp--;

                    match(input,K_TYPE,FOLLOW_K_TYPE_in_alterTableStatement2492); 
                    pushFollow(FOLLOW_comparatorType_in_alterTableStatement2496);
                    v=comparatorType();

                    state._fsp--;

                     type = AlterTableStatement.Type.ALTER; 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:503:13: K_ADD id= cident v= comparatorType
                    {
                    match(input,K_ADD,FOLLOW_K_ADD_in_alterTableStatement2512); 
                    pushFollow(FOLLOW_cident_in_alterTableStatement2518);
                    id=cident();

                    state._fsp--;

                    pushFollow(FOLLOW_comparatorType_in_alterTableStatement2522);
                    v=comparatorType();

                    state._fsp--;

                     type = AlterTableStatement.Type.ADD; 

                    }
                    break;
                case 3 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:504:13: K_DROP id= cident
                    {
                    match(input,K_DROP,FOLLOW_K_DROP_in_alterTableStatement2545); 
                    pushFollow(FOLLOW_cident_in_alterTableStatement2550);
                    id=cident();

                    state._fsp--;

                     type = AlterTableStatement.Type.DROP; 

                    }
                    break;
                case 4 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:505:13: K_WITH properties[props]
                    {
                    match(input,K_WITH,FOLLOW_K_WITH_in_alterTableStatement2590); 
                    pushFollow(FOLLOW_properties_in_alterTableStatement2593);
                    properties(props);

                    state._fsp--;

                     type = AlterTableStatement.Type.OPTS; 

                    }
                    break;
                case 5 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:506:13: K_RENAME id1= cident K_TO toId1= cident ( K_AND idn= cident K_TO toIdn= cident )*
                    {
                    match(input,K_RENAME,FOLLOW_K_RENAME_in_alterTableStatement2626); 
                     type = AlterTableStatement.Type.RENAME; 
                    pushFollow(FOLLOW_cident_in_alterTableStatement2680);
                    id1=cident();

                    state._fsp--;

                    match(input,K_TO,FOLLOW_K_TO_in_alterTableStatement2682); 
                    pushFollow(FOLLOW_cident_in_alterTableStatement2686);
                    toId1=cident();

                    state._fsp--;

                     renames.put(id1, toId1); 
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:508:16: ( K_AND idn= cident K_TO toIdn= cident )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==K_AND) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:508:18: K_AND idn= cident K_TO toIdn= cident
                    	    {
                    	    match(input,K_AND,FOLLOW_K_AND_in_alterTableStatement2707); 
                    	    pushFollow(FOLLOW_cident_in_alterTableStatement2711);
                    	    idn=cident();

                    	    state._fsp--;

                    	    match(input,K_TO,FOLLOW_K_TO_in_alterTableStatement2713); 
                    	    pushFollow(FOLLOW_cident_in_alterTableStatement2717);
                    	    toIdn=cident();

                    	    state._fsp--;

                    	     renames.put(idn, toIdn); 

                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);


                    }
                    break;

            }


                    expr = new AlterTableStatement(cf, type, id, v, props, renames);
                

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "alterTableStatement"


    // $ANTLR start "dropKeyspaceStatement"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:515:1: dropKeyspaceStatement returns [DropKeyspaceStatement ksp] : K_DROP K_KEYSPACE ks= keyspaceName ;
    public final DropKeyspaceStatement dropKeyspaceStatement() throws RecognitionException {
        DropKeyspaceStatement ksp = null;

        String ks = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:519:5: ( K_DROP K_KEYSPACE ks= keyspaceName )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:519:7: K_DROP K_KEYSPACE ks= keyspaceName
            {
            match(input,K_DROP,FOLLOW_K_DROP_in_dropKeyspaceStatement2763); 
            match(input,K_KEYSPACE,FOLLOW_K_KEYSPACE_in_dropKeyspaceStatement2765); 
            pushFollow(FOLLOW_keyspaceName_in_dropKeyspaceStatement2769);
            ks=keyspaceName();

            state._fsp--;

             ksp = new DropKeyspaceStatement(ks); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ksp;
    }
    // $ANTLR end "dropKeyspaceStatement"


    // $ANTLR start "dropColumnFamilyStatement"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:522:1: dropColumnFamilyStatement returns [DropColumnFamilyStatement stmt] : K_DROP K_COLUMNFAMILY cf= columnFamilyName ;
    public final DropColumnFamilyStatement dropColumnFamilyStatement() throws RecognitionException {
        DropColumnFamilyStatement stmt = null;

        CFName cf = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:526:5: ( K_DROP K_COLUMNFAMILY cf= columnFamilyName )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:526:7: K_DROP K_COLUMNFAMILY cf= columnFamilyName
            {
            match(input,K_DROP,FOLLOW_K_DROP_in_dropColumnFamilyStatement2794); 
            match(input,K_COLUMNFAMILY,FOLLOW_K_COLUMNFAMILY_in_dropColumnFamilyStatement2796); 
            pushFollow(FOLLOW_columnFamilyName_in_dropColumnFamilyStatement2800);
            cf=columnFamilyName();

            state._fsp--;

             stmt = new DropColumnFamilyStatement(cf); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "dropColumnFamilyStatement"


    // $ANTLR start "dropIndexStatement"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:529:1: dropIndexStatement returns [DropIndexStatement expr] : K_DROP K_INDEX index= IDENT ;
    public final DropIndexStatement dropIndexStatement() throws RecognitionException {
        DropIndexStatement expr = null;

        Token index=null;

        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:533:5: ( K_DROP K_INDEX index= IDENT )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:534:7: K_DROP K_INDEX index= IDENT
            {
            match(input,K_DROP,FOLLOW_K_DROP_in_dropIndexStatement2831); 
            match(input,K_INDEX,FOLLOW_K_INDEX_in_dropIndexStatement2833); 
            index=(Token)match(input,IDENT,FOLLOW_IDENT_in_dropIndexStatement2837); 
             expr = new DropIndexStatement((index!=null?index.getText():null)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "dropIndexStatement"


    // $ANTLR start "truncateStatement"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:538:1: truncateStatement returns [TruncateStatement stmt] : K_TRUNCATE cf= columnFamilyName ;
    public final TruncateStatement truncateStatement() throws RecognitionException {
        TruncateStatement stmt = null;

        CFName cf = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:542:5: ( K_TRUNCATE cf= columnFamilyName )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:542:7: K_TRUNCATE cf= columnFamilyName
            {
            match(input,K_TRUNCATE,FOLLOW_K_TRUNCATE_in_truncateStatement2868); 
            pushFollow(FOLLOW_columnFamilyName_in_truncateStatement2872);
            cf=columnFamilyName();

            state._fsp--;

             stmt = new TruncateStatement(cf); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "truncateStatement"


    // $ANTLR start "grantStatement"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:545:1: grantStatement returns [GrantStatement stmt] : K_GRANT permissionOrAll K_ON resource K_TO username ;
    public final GrantStatement grantStatement() throws RecognitionException {
        GrantStatement stmt = null;

        Set<Permission> permissionOrAll1 = null;

        IResource resource2 = null;

        CqlParser.username_return username3 = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:549:5: ( K_GRANT permissionOrAll K_ON resource K_TO username )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:549:7: K_GRANT permissionOrAll K_ON resource K_TO username
            {
            match(input,K_GRANT,FOLLOW_K_GRANT_in_grantStatement2897); 
            pushFollow(FOLLOW_permissionOrAll_in_grantStatement2909);
            permissionOrAll1=permissionOrAll();

            state._fsp--;

            match(input,K_ON,FOLLOW_K_ON_in_grantStatement2917); 
            pushFollow(FOLLOW_resource_in_grantStatement2929);
            resource2=resource();

            state._fsp--;

            match(input,K_TO,FOLLOW_K_TO_in_grantStatement2937); 
            pushFollow(FOLLOW_username_in_grantStatement2949);
            username3=username();

            state._fsp--;

             stmt = new GrantStatement(permissionOrAll1, resource2, (username3!=null?input.toString(username3.start,username3.stop):null)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "grantStatement"


    // $ANTLR start "revokeStatement"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:558:1: revokeStatement returns [RevokeStatement stmt] : K_REVOKE permissionOrAll K_ON resource K_FROM username ;
    public final RevokeStatement revokeStatement() throws RecognitionException {
        RevokeStatement stmt = null;

        Set<Permission> permissionOrAll4 = null;

        IResource resource5 = null;

        CqlParser.username_return username6 = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:562:5: ( K_REVOKE permissionOrAll K_ON resource K_FROM username )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:562:7: K_REVOKE permissionOrAll K_ON resource K_FROM username
            {
            match(input,K_REVOKE,FOLLOW_K_REVOKE_in_revokeStatement2980); 
            pushFollow(FOLLOW_permissionOrAll_in_revokeStatement2992);
            permissionOrAll4=permissionOrAll();

            state._fsp--;

            match(input,K_ON,FOLLOW_K_ON_in_revokeStatement3000); 
            pushFollow(FOLLOW_resource_in_revokeStatement3012);
            resource5=resource();

            state._fsp--;

            match(input,K_FROM,FOLLOW_K_FROM_in_revokeStatement3020); 
            pushFollow(FOLLOW_username_in_revokeStatement3032);
            username6=username();

            state._fsp--;

             stmt = new RevokeStatement(permissionOrAll4, resource5, (username6!=null?input.toString(username6.start,username6.stop):null)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "revokeStatement"


    // $ANTLR start "listPermissionsStatement"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:571:1: listPermissionsStatement returns [ListPermissionsStatement stmt] : K_LIST permissionOrAll ( K_ON resource )? ( K_OF username )? ( K_NORECURSIVE )? ;
    public final ListPermissionsStatement listPermissionsStatement() throws RecognitionException {
        ListPermissionsStatement stmt = null;

        IResource resource7 = null;

        CqlParser.username_return username8 = null;

        Set<Permission> permissionOrAll9 = null;



                IResource resource = null;
                String username = null;
                boolean recursive = true;
            
        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:577:5: ( K_LIST permissionOrAll ( K_ON resource )? ( K_OF username )? ( K_NORECURSIVE )? )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:577:7: K_LIST permissionOrAll ( K_ON resource )? ( K_OF username )? ( K_NORECURSIVE )?
            {
            match(input,K_LIST,FOLLOW_K_LIST_in_listPermissionsStatement3070); 
            pushFollow(FOLLOW_permissionOrAll_in_listPermissionsStatement3082);
            permissionOrAll9=permissionOrAll();

            state._fsp--;

            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:579:7: ( K_ON resource )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==K_ON) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:579:9: K_ON resource
                    {
                    match(input,K_ON,FOLLOW_K_ON_in_listPermissionsStatement3092); 
                    pushFollow(FOLLOW_resource_in_listPermissionsStatement3094);
                    resource7=resource();

                    state._fsp--;

                     resource = resource7; 

                    }
                    break;

            }

            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:580:7: ( K_OF username )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==K_OF) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:580:9: K_OF username
                    {
                    match(input,K_OF,FOLLOW_K_OF_in_listPermissionsStatement3109); 
                    pushFollow(FOLLOW_username_in_listPermissionsStatement3111);
                    username8=username();

                    state._fsp--;

                     username = (username8!=null?input.toString(username8.start,username8.stop):null); 

                    }
                    break;

            }

            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:581:7: ( K_NORECURSIVE )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==K_NORECURSIVE) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:581:9: K_NORECURSIVE
                    {
                    match(input,K_NORECURSIVE,FOLLOW_K_NORECURSIVE_in_listPermissionsStatement3126); 
                     recursive = false; 

                    }
                    break;

            }

             stmt = new ListPermissionsStatement(permissionOrAll9, resource, username, recursive); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "listPermissionsStatement"


    // $ANTLR start "permission"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:585:1: permission returns [Permission perm] : p= ( K_CREATE | K_ALTER | K_DROP | K_SELECT | K_MODIFY | K_AUTHORIZE ) ;
    public final Permission permission() throws RecognitionException {
        Permission perm = null;

        Token p=null;

        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:586:5: (p= ( K_CREATE | K_ALTER | K_DROP | K_SELECT | K_MODIFY | K_AUTHORIZE ) )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:586:7: p= ( K_CREATE | K_ALTER | K_DROP | K_SELECT | K_MODIFY | K_AUTHORIZE )
            {
            p=(Token)input.LT(1);
            if ( input.LA(1)==K_SELECT||input.LA(1)==K_CREATE||input.LA(1)==K_ALTER||input.LA(1)==K_DROP||(input.LA(1)>=K_MODIFY && input.LA(1)<=K_AUTHORIZE) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

             perm = Permission.valueOf((p!=null?p.getText():null).toUpperCase()); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return perm;
    }
    // $ANTLR end "permission"


    // $ANTLR start "permissionOrAll"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:590:1: permissionOrAll returns [Set<Permission> perms] : ( K_ALL ( K_PERMISSIONS )? | p= permission ( K_PERMISSION )? );
    public final Set<Permission> permissionOrAll() throws RecognitionException {
        Set<Permission> perms = null;

        Permission p = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:591:5: ( K_ALL ( K_PERMISSIONS )? | p= permission ( K_PERMISSION )? )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==K_ALL) ) {
                alt61=1;
            }
            else if ( (LA61_0==K_SELECT||LA61_0==K_CREATE||LA61_0==K_ALTER||LA61_0==K_DROP||(LA61_0>=K_MODIFY && LA61_0<=K_AUTHORIZE)) ) {
                alt61=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:591:7: K_ALL ( K_PERMISSIONS )?
                    {
                    match(input,K_ALL,FOLLOW_K_ALL_in_permissionOrAll3211); 
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:591:13: ( K_PERMISSIONS )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==K_PERMISSIONS) ) {
                        alt59=1;
                    }
                    switch (alt59) {
                        case 1 :
                            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:591:15: K_PERMISSIONS
                            {
                            match(input,K_PERMISSIONS,FOLLOW_K_PERMISSIONS_in_permissionOrAll3215); 

                            }
                            break;

                    }

                     perms = Permission.ALL_DATA; 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:592:7: p= permission ( K_PERMISSION )?
                    {
                    pushFollow(FOLLOW_permission_in_permissionOrAll3236);
                    p=permission();

                    state._fsp--;

                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:592:20: ( K_PERMISSION )?
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==K_PERMISSION) ) {
                        alt60=1;
                    }
                    switch (alt60) {
                        case 1 :
                            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:592:22: K_PERMISSION
                            {
                            match(input,K_PERMISSION,FOLLOW_K_PERMISSION_in_permissionOrAll3240); 

                            }
                            break;

                    }

                     perms = EnumSet.of(p); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return perms;
    }
    // $ANTLR end "permissionOrAll"


    // $ANTLR start "resource"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:595:1: resource returns [IResource res] : r= dataResource ;
    public final IResource resource() throws RecognitionException {
        IResource res = null;

        DataResource r = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:596:5: (r= dataResource )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:596:7: r= dataResource
            {
            pushFollow(FOLLOW_dataResource_in_resource3268);
            r=dataResource();

            state._fsp--;

             res = r; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return res;
    }
    // $ANTLR end "resource"


    // $ANTLR start "dataResource"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:599:1: dataResource returns [DataResource res] : ( K_ALL K_KEYSPACES | K_KEYSPACE ks= keyspaceName | ( K_COLUMNFAMILY )? cf= columnFamilyName );
    public final DataResource dataResource() throws RecognitionException {
        DataResource res = null;

        String ks = null;

        CFName cf = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:600:5: ( K_ALL K_KEYSPACES | K_KEYSPACE ks= keyspaceName | ( K_COLUMNFAMILY )? cf= columnFamilyName )
            int alt63=3;
            switch ( input.LA(1) ) {
            case K_ALL:
                {
                int LA63_1 = input.LA(2);

                if ( (LA63_1==K_KEYSPACES) ) {
                    alt63=1;
                }
                else if ( (LA63_1==EOF||LA63_1==K_FROM||LA63_1==K_TO||(LA63_1>=K_OF && LA63_1<=K_NORECURSIVE)||LA63_1==129||LA63_1==136) ) {
                    alt63=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 1, input);

                    throw nvae;
                }
                }
                break;
            case K_KEYSPACE:
                {
                alt63=2;
                }
                break;
            case K_COUNT:
            case K_FILTERING:
            case K_WRITETIME:
            case K_TTL:
            case K_VALUES:
            case K_TIMESTAMP:
            case K_EXISTS:
            case K_COUNTER:
            case K_COLUMNFAMILY:
            case K_KEY:
            case K_COMPACT:
            case K_STORAGE:
            case K_CLUSTERING:
            case IDENT:
            case K_TYPE:
            case K_LIST:
            case K_PERMISSIONS:
            case K_PERMISSION:
            case K_KEYSPACES:
            case K_USER:
            case K_SUPERUSER:
            case K_NOSUPERUSER:
            case K_USERS:
            case K_PASSWORD:
            case QUOTED_NAME:
            case K_ASCII:
            case K_BIGINT:
            case K_BLOB:
            case K_BOOLEAN:
            case K_DECIMAL:
            case K_DOUBLE:
            case K_FLOAT:
            case K_INET:
            case K_INT:
            case K_TEXT:
            case K_UUID:
            case K_VARCHAR:
            case K_VARINT:
            case K_TIMEUUID:
            case K_MAP:
                {
                alt63=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:600:7: K_ALL K_KEYSPACES
                    {
                    match(input,K_ALL,FOLLOW_K_ALL_in_dataResource3291); 
                    match(input,K_KEYSPACES,FOLLOW_K_KEYSPACES_in_dataResource3293); 
                     res = DataResource.root(); 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:601:7: K_KEYSPACE ks= keyspaceName
                    {
                    match(input,K_KEYSPACE,FOLLOW_K_KEYSPACE_in_dataResource3303); 
                    pushFollow(FOLLOW_keyspaceName_in_dataResource3309);
                    ks=keyspaceName();

                    state._fsp--;

                     res = DataResource.keyspace(ks); 

                    }
                    break;
                case 3 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:602:7: ( K_COLUMNFAMILY )? cf= columnFamilyName
                    {
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:602:7: ( K_COLUMNFAMILY )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==K_COLUMNFAMILY) ) {
                        alt62=1;
                    }
                    switch (alt62) {
                        case 1 :
                            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:602:9: K_COLUMNFAMILY
                            {
                            match(input,K_COLUMNFAMILY,FOLLOW_K_COLUMNFAMILY_in_dataResource3321); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_columnFamilyName_in_dataResource3330);
                    cf=columnFamilyName();

                    state._fsp--;

                     res = DataResource.columnFamily(cf.getKeyspace(), cf.getColumnFamily()); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return res;
    }
    // $ANTLR end "dataResource"


    // $ANTLR start "createUserStatement"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:606:1: createUserStatement returns [CreateUserStatement stmt] : K_CREATE K_USER username ( K_WITH userOptions[opts] )? ( K_SUPERUSER | K_NOSUPERUSER )? ;
    public final CreateUserStatement createUserStatement() throws RecognitionException {
        CreateUserStatement stmt = null;

        CqlParser.username_return username10 = null;



                UserOptions opts = new UserOptions();
                boolean superuser = false;
            
        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:614:5: ( K_CREATE K_USER username ( K_WITH userOptions[opts] )? ( K_SUPERUSER | K_NOSUPERUSER )? )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:614:7: K_CREATE K_USER username ( K_WITH userOptions[opts] )? ( K_SUPERUSER | K_NOSUPERUSER )?
            {
            match(input,K_CREATE,FOLLOW_K_CREATE_in_createUserStatement3370); 
            match(input,K_USER,FOLLOW_K_USER_in_createUserStatement3372); 
            pushFollow(FOLLOW_username_in_createUserStatement3374);
            username10=username();

            state._fsp--;

            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:615:7: ( K_WITH userOptions[opts] )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==K_WITH) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:615:9: K_WITH userOptions[opts]
                    {
                    match(input,K_WITH,FOLLOW_K_WITH_in_createUserStatement3384); 
                    pushFollow(FOLLOW_userOptions_in_createUserStatement3386);
                    userOptions(opts);

                    state._fsp--;


                    }
                    break;

            }

            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:616:7: ( K_SUPERUSER | K_NOSUPERUSER )?
            int alt65=3;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==K_SUPERUSER) ) {
                alt65=1;
            }
            else if ( (LA65_0==K_NOSUPERUSER) ) {
                alt65=2;
            }
            switch (alt65) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:616:9: K_SUPERUSER
                    {
                    match(input,K_SUPERUSER,FOLLOW_K_SUPERUSER_in_createUserStatement3400); 
                     superuser = true; 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:616:45: K_NOSUPERUSER
                    {
                    match(input,K_NOSUPERUSER,FOLLOW_K_NOSUPERUSER_in_createUserStatement3406); 
                     superuser = false; 

                    }
                    break;

            }

             stmt = new CreateUserStatement((username10!=null?input.toString(username10.start,username10.stop):null), opts, superuser); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "createUserStatement"


    // $ANTLR start "alterUserStatement"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:620:1: alterUserStatement returns [AlterUserStatement stmt] : K_ALTER K_USER username ( K_WITH userOptions[opts] )? ( K_SUPERUSER | K_NOSUPERUSER )? ;
    public final AlterUserStatement alterUserStatement() throws RecognitionException {
        AlterUserStatement stmt = null;

        CqlParser.username_return username11 = null;



                UserOptions opts = new UserOptions();
                Boolean superuser = null;
            
        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:628:5: ( K_ALTER K_USER username ( K_WITH userOptions[opts] )? ( K_SUPERUSER | K_NOSUPERUSER )? )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:628:7: K_ALTER K_USER username ( K_WITH userOptions[opts] )? ( K_SUPERUSER | K_NOSUPERUSER )?
            {
            match(input,K_ALTER,FOLLOW_K_ALTER_in_alterUserStatement3451); 
            match(input,K_USER,FOLLOW_K_USER_in_alterUserStatement3453); 
            pushFollow(FOLLOW_username_in_alterUserStatement3455);
            username11=username();

            state._fsp--;

            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:629:7: ( K_WITH userOptions[opts] )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==K_WITH) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:629:9: K_WITH userOptions[opts]
                    {
                    match(input,K_WITH,FOLLOW_K_WITH_in_alterUserStatement3465); 
                    pushFollow(FOLLOW_userOptions_in_alterUserStatement3467);
                    userOptions(opts);

                    state._fsp--;


                    }
                    break;

            }

            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:630:7: ( K_SUPERUSER | K_NOSUPERUSER )?
            int alt67=3;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==K_SUPERUSER) ) {
                alt67=1;
            }
            else if ( (LA67_0==K_NOSUPERUSER) ) {
                alt67=2;
            }
            switch (alt67) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:630:9: K_SUPERUSER
                    {
                    match(input,K_SUPERUSER,FOLLOW_K_SUPERUSER_in_alterUserStatement3481); 
                     superuser = true; 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:630:45: K_NOSUPERUSER
                    {
                    match(input,K_NOSUPERUSER,FOLLOW_K_NOSUPERUSER_in_alterUserStatement3487); 
                     superuser = false; 

                    }
                    break;

            }

             stmt = new AlterUserStatement((username11!=null?input.toString(username11.start,username11.stop):null), opts, superuser); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "alterUserStatement"


    // $ANTLR start "dropUserStatement"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:634:1: dropUserStatement returns [DropUserStatement stmt] : K_DROP K_USER username ;
    public final DropUserStatement dropUserStatement() throws RecognitionException {
        DropUserStatement stmt = null;

        CqlParser.username_return username12 = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:638:5: ( K_DROP K_USER username )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:638:7: K_DROP K_USER username
            {
            match(input,K_DROP,FOLLOW_K_DROP_in_dropUserStatement3523); 
            match(input,K_USER,FOLLOW_K_USER_in_dropUserStatement3525); 
            pushFollow(FOLLOW_username_in_dropUserStatement3527);
            username12=username();

            state._fsp--;

             stmt = new DropUserStatement((username12!=null?input.toString(username12.start,username12.stop):null)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "dropUserStatement"


    // $ANTLR start "listUsersStatement"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:641:1: listUsersStatement returns [ListUsersStatement stmt] : K_LIST K_USERS ;
    public final ListUsersStatement listUsersStatement() throws RecognitionException {
        ListUsersStatement stmt = null;

        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:645:5: ( K_LIST K_USERS )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:645:7: K_LIST K_USERS
            {
            match(input,K_LIST,FOLLOW_K_LIST_in_listUsersStatement3552); 
            match(input,K_USERS,FOLLOW_K_USERS_in_listUsersStatement3554); 
             stmt = new ListUsersStatement(); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "listUsersStatement"


    // $ANTLR start "userOptions"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:648:1: userOptions[UserOptions opts] : userOption[opts] ;
    public final void userOptions(UserOptions opts) throws RecognitionException {
        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:649:5: ( userOption[opts] )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:649:7: userOption[opts]
            {
            pushFollow(FOLLOW_userOption_in_userOptions3574);
            userOption(opts);

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "userOptions"


    // $ANTLR start "userOption"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:652:1: userOption[UserOptions opts] : k= K_PASSWORD v= STRING_LITERAL ;
    public final void userOption(UserOptions opts) throws RecognitionException {
        Token k=null;
        Token v=null;

        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:653:5: (k= K_PASSWORD v= STRING_LITERAL )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:653:7: k= K_PASSWORD v= STRING_LITERAL
            {
            k=(Token)match(input,K_PASSWORD,FOLLOW_K_PASSWORD_in_userOption3595); 
            v=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_userOption3599); 
             opts.put((k!=null?k.getText():null), (v!=null?v.getText():null)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "userOption"


    // $ANTLR start "cident"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:656:1: cident returns [ColumnIdentifier id] : (t= IDENT | t= QUOTED_NAME | k= unreserved_keyword );
    public final ColumnIdentifier cident() throws RecognitionException {
        ColumnIdentifier id = null;

        Token t=null;
        String k = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:660:5: (t= IDENT | t= QUOTED_NAME | k= unreserved_keyword )
            int alt68=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt68=1;
                }
                break;
            case QUOTED_NAME:
                {
                alt68=2;
                }
                break;
            case K_COUNT:
            case K_FILTERING:
            case K_WRITETIME:
            case K_TTL:
            case K_VALUES:
            case K_TIMESTAMP:
            case K_EXISTS:
            case K_COUNTER:
            case K_KEY:
            case K_COMPACT:
            case K_STORAGE:
            case K_CLUSTERING:
            case K_TYPE:
            case K_LIST:
            case K_ALL:
            case K_PERMISSIONS:
            case K_PERMISSION:
            case K_KEYSPACES:
            case K_USER:
            case K_SUPERUSER:
            case K_NOSUPERUSER:
            case K_USERS:
            case K_PASSWORD:
            case K_ASCII:
            case K_BIGINT:
            case K_BLOB:
            case K_BOOLEAN:
            case K_DECIMAL:
            case K_DOUBLE:
            case K_FLOAT:
            case K_INET:
            case K_INT:
            case K_TEXT:
            case K_UUID:
            case K_VARCHAR:
            case K_VARINT:
            case K_TIMEUUID:
            case K_MAP:
                {
                alt68=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }

            switch (alt68) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:660:7: t= IDENT
                    {
                    t=(Token)match(input,IDENT,FOLLOW_IDENT_in_cident3628); 
                     id = new ColumnIdentifier((t!=null?t.getText():null), false); 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:661:7: t= QUOTED_NAME
                    {
                    t=(Token)match(input,QUOTED_NAME,FOLLOW_QUOTED_NAME_in_cident3653); 
                     id = new ColumnIdentifier((t!=null?t.getText():null), true); 

                    }
                    break;
                case 3 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:662:7: k= unreserved_keyword
                    {
                    pushFollow(FOLLOW_unreserved_keyword_in_cident3672);
                    k=unreserved_keyword();

                    state._fsp--;

                     id = new ColumnIdentifier(k, false); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return id;
    }
    // $ANTLR end "cident"


    // $ANTLR start "keyspaceName"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:666:1: keyspaceName returns [String id] : cfOrKsName[name, true] ;
    public final String keyspaceName() throws RecognitionException {
        String id = null;

         CFName name = new CFName(); 
        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:668:5: ( cfOrKsName[name, true] )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:668:7: cfOrKsName[name, true]
            {
            pushFollow(FOLLOW_cfOrKsName_in_keyspaceName3705);
            cfOrKsName(name, true);

            state._fsp--;

             id = name.getKeyspace(); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return id;
    }
    // $ANTLR end "keyspaceName"


    // $ANTLR start "columnFamilyName"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:671:1: columnFamilyName returns [CFName name] : ( cfOrKsName[name, true] '.' )? cfOrKsName[name, false] ;
    public final CFName columnFamilyName() throws RecognitionException {
        CFName name = null;

         name = new CFName(); 
        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:673:5: ( ( cfOrKsName[name, true] '.' )? cfOrKsName[name, false] )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:673:7: ( cfOrKsName[name, true] '.' )? cfOrKsName[name, false]
            {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:673:7: ( cfOrKsName[name, true] '.' )?
            int alt69=2;
            alt69 = dfa69.predict(input);
            switch (alt69) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:673:8: cfOrKsName[name, true] '.'
                    {
                    pushFollow(FOLLOW_cfOrKsName_in_columnFamilyName3739);
                    cfOrKsName(name, true);

                    state._fsp--;

                    match(input,136,FOLLOW_136_in_columnFamilyName3742); 

                    }
                    break;

            }

            pushFollow(FOLLOW_cfOrKsName_in_columnFamilyName3746);
            cfOrKsName(name, false);

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return name;
    }
    // $ANTLR end "columnFamilyName"


    // $ANTLR start "cfOrKsName"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:676:1: cfOrKsName[CFName name, boolean isKs] : (t= IDENT | t= QUOTED_NAME | k= unreserved_keyword );
    public final void cfOrKsName(CFName name, boolean isKs) throws RecognitionException {
        Token t=null;
        String k = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:677:5: (t= IDENT | t= QUOTED_NAME | k= unreserved_keyword )
            int alt70=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt70=1;
                }
                break;
            case QUOTED_NAME:
                {
                alt70=2;
                }
                break;
            case K_COUNT:
            case K_FILTERING:
            case K_WRITETIME:
            case K_TTL:
            case K_VALUES:
            case K_TIMESTAMP:
            case K_EXISTS:
            case K_COUNTER:
            case K_KEY:
            case K_COMPACT:
            case K_STORAGE:
            case K_CLUSTERING:
            case K_TYPE:
            case K_LIST:
            case K_ALL:
            case K_PERMISSIONS:
            case K_PERMISSION:
            case K_KEYSPACES:
            case K_USER:
            case K_SUPERUSER:
            case K_NOSUPERUSER:
            case K_USERS:
            case K_PASSWORD:
            case K_ASCII:
            case K_BIGINT:
            case K_BLOB:
            case K_BOOLEAN:
            case K_DECIMAL:
            case K_DOUBLE:
            case K_FLOAT:
            case K_INET:
            case K_INT:
            case K_TEXT:
            case K_UUID:
            case K_VARCHAR:
            case K_VARINT:
            case K_TIMEUUID:
            case K_MAP:
                {
                alt70=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }

            switch (alt70) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:677:7: t= IDENT
                    {
                    t=(Token)match(input,IDENT,FOLLOW_IDENT_in_cfOrKsName3767); 
                     if (isKs) name.setKeyspace((t!=null?t.getText():null), false); else name.setColumnFamily((t!=null?t.getText():null), false); 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:678:7: t= QUOTED_NAME
                    {
                    t=(Token)match(input,QUOTED_NAME,FOLLOW_QUOTED_NAME_in_cfOrKsName3792); 
                     if (isKs) name.setKeyspace((t!=null?t.getText():null), true); else name.setColumnFamily((t!=null?t.getText():null), true); 

                    }
                    break;
                case 3 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:679:7: k= unreserved_keyword
                    {
                    pushFollow(FOLLOW_unreserved_keyword_in_cfOrKsName3811);
                    k=unreserved_keyword();

                    state._fsp--;

                     if (isKs) name.setKeyspace(k, false); else name.setColumnFamily(k, false); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "cfOrKsName"


    // $ANTLR start "constant"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:682:1: constant returns [Constants.Literal constant] : (t= STRING_LITERAL | t= INTEGER | t= FLOAT | t= BOOLEAN | t= UUID | t= HEXNUMBER );
    public final Constants.Literal constant() throws RecognitionException {
        Constants.Literal constant = null;

        Token t=null;

        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:683:5: (t= STRING_LITERAL | t= INTEGER | t= FLOAT | t= BOOLEAN | t= UUID | t= HEXNUMBER )
            int alt71=6;
            switch ( input.LA(1) ) {
            case STRING_LITERAL:
                {
                alt71=1;
                }
                break;
            case INTEGER:
                {
                alt71=2;
                }
                break;
            case FLOAT:
                {
                alt71=3;
                }
                break;
            case BOOLEAN:
                {
                alt71=4;
                }
                break;
            case UUID:
                {
                alt71=5;
                }
                break;
            case HEXNUMBER:
                {
                alt71=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }

            switch (alt71) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:683:7: t= STRING_LITERAL
                    {
                    t=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_constant3836); 
                     constant = Constants.Literal.string((t!=null?t.getText():null)); 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:684:7: t= INTEGER
                    {
                    t=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_constant3848); 
                     constant = Constants.Literal.integer((t!=null?t.getText():null)); 

                    }
                    break;
                case 3 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:685:7: t= FLOAT
                    {
                    t=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_constant3867); 
                     constant = Constants.Literal.floatingPoint((t!=null?t.getText():null)); 

                    }
                    break;
                case 4 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:686:7: t= BOOLEAN
                    {
                    t=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_constant3888); 
                     constant = Constants.Literal.bool((t!=null?t.getText():null)); 

                    }
                    break;
                case 5 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:687:7: t= UUID
                    {
                    t=(Token)match(input,UUID,FOLLOW_UUID_in_constant3907); 
                     constant = Constants.Literal.uuid((t!=null?t.getText():null)); 

                    }
                    break;
                case 6 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:688:7: t= HEXNUMBER
                    {
                    t=(Token)match(input,HEXNUMBER,FOLLOW_HEXNUMBER_in_constant3929); 
                     constant = Constants.Literal.hex((t!=null?t.getText():null)); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return constant;
    }
    // $ANTLR end "constant"


    // $ANTLR start "set_tail"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:691:1: set_tail[List<Term.Raw> s] : ( '}' | ',' t= term set_tail[s] );
    public final void set_tail(List<Term.Raw> s) throws RecognitionException {
        Term.Raw t = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:692:5: ( '}' | ',' t= term set_tail[s] )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==137) ) {
                alt72=1;
            }
            else if ( (LA72_0==132) ) {
                alt72=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:692:7: '}'
                    {
                    match(input,137,FOLLOW_137_in_set_tail3954); 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:693:7: ',' t= term set_tail[s]
                    {
                    match(input,132,FOLLOW_132_in_set_tail3962); 
                    pushFollow(FOLLOW_term_in_set_tail3966);
                    t=term();

                    state._fsp--;

                     s.add(t); 
                    pushFollow(FOLLOW_set_tail_in_set_tail3970);
                    set_tail(s);

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "set_tail"


    // $ANTLR start "map_tail"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:696:1: map_tail[List<Pair<Term.Raw, Term.Raw>> m] : ( '}' | ',' k= term ':' v= term map_tail[m] );
    public final void map_tail(List<Pair<Term.Raw, Term.Raw>> m) throws RecognitionException {
        Term.Raw k = null;

        Term.Raw v = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:697:5: ( '}' | ',' k= term ':' v= term map_tail[m] )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==137) ) {
                alt73=1;
            }
            else if ( (LA73_0==132) ) {
                alt73=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:697:7: '}'
                    {
                    match(input,137,FOLLOW_137_in_map_tail3989); 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:698:7: ',' k= term ':' v= term map_tail[m]
                    {
                    match(input,132,FOLLOW_132_in_map_tail3997); 
                    pushFollow(FOLLOW_term_in_map_tail4001);
                    k=term();

                    state._fsp--;

                    match(input,138,FOLLOW_138_in_map_tail4003); 
                    pushFollow(FOLLOW_term_in_map_tail4007);
                    v=term();

                    state._fsp--;

                     m.add(Pair.create(k, v)); 
                    pushFollow(FOLLOW_map_tail_in_map_tail4011);
                    map_tail(m);

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "map_tail"


    // $ANTLR start "map_literal"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:701:1: map_literal returns [Maps.Literal map] : ( '{' '}' | '{' k1= term ':' v1= term map_tail[m] );
    public final Maps.Literal map_literal() throws RecognitionException {
        Maps.Literal map = null;

        Term.Raw k1 = null;

        Term.Raw v1 = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:702:5: ( '{' '}' | '{' k1= term ':' v1= term map_tail[m] )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==139) ) {
                int LA74_1 = input.LA(2);

                if ( (LA74_1==137) ) {
                    alt74=1;
                }
                else if ( (LA74_1==INTEGER||LA74_1==K_FILTERING||LA74_1==K_VALUES||LA74_1==K_TIMESTAMP||LA74_1==K_EXISTS||LA74_1==K_COUNTER||(LA74_1>=K_KEY && LA74_1<=K_CLUSTERING)||LA74_1==IDENT||LA74_1==K_TYPE||LA74_1==K_LIST||(LA74_1>=K_ALL && LA74_1<=STRING_LITERAL)||(LA74_1>=FLOAT && LA74_1<=K_TOKEN)||(LA74_1>=K_ASCII && LA74_1<=K_MAP)||LA74_1==130||LA74_1==134||LA74_1==139) ) {
                    alt74=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 74, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:702:7: '{' '}'
                    {
                    match(input,139,FOLLOW_139_in_map_literal4033); 
                    match(input,137,FOLLOW_137_in_map_literal4035); 
                     map = new Maps.Literal(Collections.<Pair<Term.Raw, Term.Raw>>emptyList()); 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:703:7: '{' k1= term ':' v1= term map_tail[m]
                    {
                    match(input,139,FOLLOW_139_in_map_literal4045); 
                     List<Pair<Term.Raw, Term.Raw>> m = new ArrayList<Pair<Term.Raw, Term.Raw>>(); 
                    pushFollow(FOLLOW_term_in_map_literal4061);
                    k1=term();

                    state._fsp--;

                    match(input,138,FOLLOW_138_in_map_literal4063); 
                    pushFollow(FOLLOW_term_in_map_literal4067);
                    v1=term();

                    state._fsp--;

                     m.add(Pair.create(k1, v1)); 
                    pushFollow(FOLLOW_map_tail_in_map_literal4071);
                    map_tail(m);

                    state._fsp--;

                     map = new Maps.Literal(m); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return map;
    }
    // $ANTLR end "map_literal"


    // $ANTLR start "set_or_map"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:708:1: set_or_map[Term.Raw t] returns [Term.Raw value] : ( ':' v= term map_tail[m] | set_tail[s] );
    public final Term.Raw set_or_map(Term.Raw t) throws RecognitionException {
        Term.Raw value = null;

        Term.Raw v = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:709:5: ( ':' v= term map_tail[m] | set_tail[s] )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==138) ) {
                alt75=1;
            }
            else if ( (LA75_0==132||LA75_0==137) ) {
                alt75=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:709:7: ':' v= term map_tail[m]
                    {
                    match(input,138,FOLLOW_138_in_set_or_map4103); 
                    pushFollow(FOLLOW_term_in_set_or_map4107);
                    v=term();

                    state._fsp--;

                     List<Pair<Term.Raw, Term.Raw>> m = new ArrayList<Pair<Term.Raw, Term.Raw>>(); m.add(Pair.create(t, v)); 
                    pushFollow(FOLLOW_map_tail_in_set_or_map4111);
                    map_tail(m);

                    state._fsp--;

                     value = new Maps.Literal(m); 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:710:7: set_tail[s]
                    {
                     List<Term.Raw> s = new ArrayList<Term.Raw>(); s.add(t); 
                    pushFollow(FOLLOW_set_tail_in_set_or_map4124);
                    set_tail(s);

                    state._fsp--;

                     value = new Sets.Literal(s); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "set_or_map"


    // $ANTLR start "collection_literal"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:714:1: collection_literal returns [Term.Raw value] : ( '[' (t1= term ( ',' tn= term )* )? ']' | '{' t= term v= set_or_map[t] | '{' '}' );
    public final Term.Raw collection_literal() throws RecognitionException {
        Term.Raw value = null;

        Term.Raw t1 = null;

        Term.Raw tn = null;

        Term.Raw t = null;

        Term.Raw v = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:715:5: ( '[' (t1= term ( ',' tn= term )* )? ']' | '{' t= term v= set_or_map[t] | '{' '}' )
            int alt78=3;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==134) ) {
                alt78=1;
            }
            else if ( (LA78_0==139) ) {
                int LA78_2 = input.LA(2);

                if ( (LA78_2==137) ) {
                    alt78=3;
                }
                else if ( (LA78_2==INTEGER||LA78_2==K_FILTERING||LA78_2==K_VALUES||LA78_2==K_TIMESTAMP||LA78_2==K_EXISTS||LA78_2==K_COUNTER||(LA78_2>=K_KEY && LA78_2<=K_CLUSTERING)||LA78_2==IDENT||LA78_2==K_TYPE||LA78_2==K_LIST||(LA78_2>=K_ALL && LA78_2<=STRING_LITERAL)||(LA78_2>=FLOAT && LA78_2<=K_TOKEN)||(LA78_2>=K_ASCII && LA78_2<=K_MAP)||LA78_2==130||LA78_2==134||LA78_2==139) ) {
                    alt78=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 78, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:715:7: '[' (t1= term ( ',' tn= term )* )? ']'
                    {
                    match(input,134,FOLLOW_134_in_collection_literal4149); 
                     List<Term.Raw> l = new ArrayList<Term.Raw>(); 
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:715:61: (t1= term ( ',' tn= term )* )?
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==INTEGER||LA77_0==K_FILTERING||LA77_0==K_VALUES||LA77_0==K_TIMESTAMP||LA77_0==K_EXISTS||LA77_0==K_COUNTER||(LA77_0>=K_KEY && LA77_0<=K_CLUSTERING)||LA77_0==IDENT||LA77_0==K_TYPE||LA77_0==K_LIST||(LA77_0>=K_ALL && LA77_0<=STRING_LITERAL)||(LA77_0>=FLOAT && LA77_0<=K_TOKEN)||(LA77_0>=K_ASCII && LA77_0<=K_MAP)||LA77_0==130||LA77_0==134||LA77_0==139) ) {
                        alt77=1;
                    }
                    switch (alt77) {
                        case 1 :
                            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:715:63: t1= term ( ',' tn= term )*
                            {
                            pushFollow(FOLLOW_term_in_collection_literal4157);
                            t1=term();

                            state._fsp--;

                             l.add(t1); 
                            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:715:86: ( ',' tn= term )*
                            loop76:
                            do {
                                int alt76=2;
                                int LA76_0 = input.LA(1);

                                if ( (LA76_0==132) ) {
                                    alt76=1;
                                }


                                switch (alt76) {
                            	case 1 :
                            	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:715:88: ',' tn= term
                            	    {
                            	    match(input,132,FOLLOW_132_in_collection_literal4163); 
                            	    pushFollow(FOLLOW_term_in_collection_literal4167);
                            	    tn=term();

                            	    state._fsp--;

                            	     l.add(tn); 

                            	    }
                            	    break;

                            	default :
                            	    break loop76;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,135,FOLLOW_135_in_collection_literal4177); 
                     value = new Lists.Literal(l); 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:716:7: '{' t= term v= set_or_map[t]
                    {
                    match(input,139,FOLLOW_139_in_collection_literal4187); 
                    pushFollow(FOLLOW_term_in_collection_literal4191);
                    t=term();

                    state._fsp--;

                    pushFollow(FOLLOW_set_or_map_in_collection_literal4195);
                    v=set_or_map(t);

                    state._fsp--;

                     value = v; 

                    }
                    break;
                case 3 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:718:7: '{' '}'
                    {
                    match(input,139,FOLLOW_139_in_collection_literal4211); 
                    match(input,137,FOLLOW_137_in_collection_literal4213); 
                     value = new Sets.Literal(Collections.<Term.Raw>emptyList()); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "collection_literal"


    // $ANTLR start "value"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:721:1: value returns [Term.Raw value] : (c= constant | l= collection_literal | K_NULL | QMARK );
    public final Term.Raw value() throws RecognitionException {
        Term.Raw value = null;

        Constants.Literal c = null;

        Term.Raw l = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:722:5: (c= constant | l= collection_literal | K_NULL | QMARK )
            int alt79=4;
            switch ( input.LA(1) ) {
            case INTEGER:
            case STRING_LITERAL:
            case FLOAT:
            case BOOLEAN:
            case UUID:
            case HEXNUMBER:
                {
                alt79=1;
                }
                break;
            case 134:
            case 139:
                {
                alt79=2;
                }
                break;
            case K_NULL:
                {
                alt79=3;
                }
                break;
            case QMARK:
                {
                alt79=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }

            switch (alt79) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:722:7: c= constant
                    {
                    pushFollow(FOLLOW_constant_in_value4238);
                    c=constant();

                    state._fsp--;

                     value = c; 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:723:7: l= collection_literal
                    {
                    pushFollow(FOLLOW_collection_literal_in_value4260);
                    l=collection_literal();

                    state._fsp--;

                     value = l; 

                    }
                    break;
                case 3 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:724:7: K_NULL
                    {
                    match(input,K_NULL,FOLLOW_K_NULL_in_value4270); 
                     value = Constants.NULL_LITERAL; 

                    }
                    break;
                case 4 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:725:7: QMARK
                    {
                    match(input,QMARK,FOLLOW_QMARK_in_value4294); 
                     value = new AbstractMarker.Raw(++currentBindMarkerIdx); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "value"


    // $ANTLR start "functionName"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:728:1: functionName returns [String s] : (f= IDENT | u= unreserved_function_keyword | K_TOKEN );
    public final String functionName() throws RecognitionException {
        String s = null;

        Token f=null;
        String u = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:729:5: (f= IDENT | u= unreserved_function_keyword | K_TOKEN )
            int alt80=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt80=1;
                }
                break;
            case K_FILTERING:
            case K_VALUES:
            case K_TIMESTAMP:
            case K_EXISTS:
            case K_COUNTER:
            case K_KEY:
            case K_COMPACT:
            case K_STORAGE:
            case K_CLUSTERING:
            case K_TYPE:
            case K_LIST:
            case K_ALL:
            case K_PERMISSIONS:
            case K_PERMISSION:
            case K_KEYSPACES:
            case K_USER:
            case K_SUPERUSER:
            case K_NOSUPERUSER:
            case K_USERS:
            case K_PASSWORD:
            case K_ASCII:
            case K_BIGINT:
            case K_BLOB:
            case K_BOOLEAN:
            case K_DECIMAL:
            case K_DOUBLE:
            case K_FLOAT:
            case K_INET:
            case K_INT:
            case K_TEXT:
            case K_UUID:
            case K_VARCHAR:
            case K_VARINT:
            case K_TIMEUUID:
            case K_MAP:
                {
                alt80=2;
                }
                break;
            case K_TOKEN:
                {
                alt80=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }

            switch (alt80) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:729:7: f= IDENT
                    {
                    f=(Token)match(input,IDENT,FOLLOW_IDENT_in_functionName4334); 
                     s = (f!=null?f.getText():null); 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:730:7: u= unreserved_function_keyword
                    {
                    pushFollow(FOLLOW_unreserved_function_keyword_in_functionName4368);
                    u=unreserved_function_keyword();

                    state._fsp--;

                     s = u; 

                    }
                    break;
                case 3 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:731:7: K_TOKEN
                    {
                    match(input,K_TOKEN,FOLLOW_K_TOKEN_in_functionName4378); 
                     s = "token"; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "functionName"


    // $ANTLR start "functionArgs"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:734:1: functionArgs returns [List<Term.Raw> a] : ( '(' ')' | '(' t1= term ( ',' tn= term )* ')' );
    public final List<Term.Raw> functionArgs() throws RecognitionException {
        List<Term.Raw> a = null;

        Term.Raw t1 = null;

        Term.Raw tn = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:735:5: ( '(' ')' | '(' t1= term ( ',' tn= term )* ')' )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==130) ) {
                int LA82_1 = input.LA(2);

                if ( (LA82_1==131) ) {
                    alt82=1;
                }
                else if ( (LA82_1==INTEGER||LA82_1==K_FILTERING||LA82_1==K_VALUES||LA82_1==K_TIMESTAMP||LA82_1==K_EXISTS||LA82_1==K_COUNTER||(LA82_1>=K_KEY && LA82_1<=K_CLUSTERING)||LA82_1==IDENT||LA82_1==K_TYPE||LA82_1==K_LIST||(LA82_1>=K_ALL && LA82_1<=STRING_LITERAL)||(LA82_1>=FLOAT && LA82_1<=K_TOKEN)||(LA82_1>=K_ASCII && LA82_1<=K_MAP)||LA82_1==130||LA82_1==134||LA82_1==139) ) {
                    alt82=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 82, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:735:7: '(' ')'
                    {
                    match(input,130,FOLLOW_130_in_functionArgs4423); 
                    match(input,131,FOLLOW_131_in_functionArgs4425); 
                     a = Collections.emptyList(); 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:736:7: '(' t1= term ( ',' tn= term )* ')'
                    {
                    match(input,130,FOLLOW_130_in_functionArgs4435); 
                    pushFollow(FOLLOW_term_in_functionArgs4439);
                    t1=term();

                    state._fsp--;

                     List<Term.Raw> args = new ArrayList<Term.Raw>(); args.add(t1); 
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:737:11: ( ',' tn= term )*
                    loop81:
                    do {
                        int alt81=2;
                        int LA81_0 = input.LA(1);

                        if ( (LA81_0==132) ) {
                            alt81=1;
                        }


                        switch (alt81) {
                    	case 1 :
                    	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:737:13: ',' tn= term
                    	    {
                    	    match(input,132,FOLLOW_132_in_functionArgs4455); 
                    	    pushFollow(FOLLOW_term_in_functionArgs4459);
                    	    tn=term();

                    	    state._fsp--;

                    	     args.add(tn); 

                    	    }
                    	    break;

                    	default :
                    	    break loop81;
                        }
                    } while (true);

                    match(input,131,FOLLOW_131_in_functionArgs4473); 
                     a = args; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return a;
    }
    // $ANTLR end "functionArgs"


    // $ANTLR start "term"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:741:1: term returns [Term.Raw term] : (v= value | f= functionName args= functionArgs | '(' c= comparatorType ')' t= term );
    public final Term.Raw term() throws RecognitionException {
        Term.Raw term = null;

        Term.Raw v = null;

        String f = null;

        List<Term.Raw> args = null;

        CQL3Type c = null;

        Term.Raw t = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:742:5: (v= value | f= functionName args= functionArgs | '(' c= comparatorType ')' t= term )
            int alt83=3;
            switch ( input.LA(1) ) {
            case INTEGER:
            case STRING_LITERAL:
            case FLOAT:
            case BOOLEAN:
            case UUID:
            case HEXNUMBER:
            case K_NULL:
            case QMARK:
            case 134:
            case 139:
                {
                alt83=1;
                }
                break;
            case K_FILTERING:
            case K_VALUES:
            case K_TIMESTAMP:
            case K_EXISTS:
            case K_COUNTER:
            case K_KEY:
            case K_COMPACT:
            case K_STORAGE:
            case K_CLUSTERING:
            case IDENT:
            case K_TYPE:
            case K_LIST:
            case K_ALL:
            case K_PERMISSIONS:
            case K_PERMISSION:
            case K_KEYSPACES:
            case K_USER:
            case K_SUPERUSER:
            case K_NOSUPERUSER:
            case K_USERS:
            case K_PASSWORD:
            case K_TOKEN:
            case K_ASCII:
            case K_BIGINT:
            case K_BLOB:
            case K_BOOLEAN:
            case K_DECIMAL:
            case K_DOUBLE:
            case K_FLOAT:
            case K_INET:
            case K_INT:
            case K_TEXT:
            case K_UUID:
            case K_VARCHAR:
            case K_VARINT:
            case K_TIMEUUID:
            case K_MAP:
                {
                alt83=2;
                }
                break;
            case 130:
                {
                alt83=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }

            switch (alt83) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:742:7: v= value
                    {
                    pushFollow(FOLLOW_value_in_term4498);
                    v=value();

                    state._fsp--;

                     term = v; 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:743:7: f= functionName args= functionArgs
                    {
                    pushFollow(FOLLOW_functionName_in_term4535);
                    f=functionName();

                    state._fsp--;

                    pushFollow(FOLLOW_functionArgs_in_term4539);
                    args=functionArgs();

                    state._fsp--;

                     term = new FunctionCall.Raw(f, args); 

                    }
                    break;
                case 3 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:744:7: '(' c= comparatorType ')' t= term
                    {
                    match(input,130,FOLLOW_130_in_term4549); 
                    pushFollow(FOLLOW_comparatorType_in_term4553);
                    c=comparatorType();

                    state._fsp--;

                    match(input,131,FOLLOW_131_in_term4555); 
                    pushFollow(FOLLOW_term_in_term4559);
                    t=term();

                    state._fsp--;

                     term = new TypeCast(c, t); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return term;
    }
    // $ANTLR end "term"


    // $ANTLR start "columnOperation"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:747:1: columnOperation[List<Pair<ColumnIdentifier, Operation.RawUpdate>> operations] : (key= cident '=' t= term ( '+' c= cident )? | key= cident '=' c= cident sig= ( '+' | '-' ) t= term | key= cident '=' c= cident i= INTEGER | key= cident '[' k= term ']' '=' t= term );
    public final void columnOperation(List<Pair<ColumnIdentifier, Operation.RawUpdate>> operations) throws RecognitionException {
        Token sig=null;
        Token i=null;
        ColumnIdentifier key = null;

        Term.Raw t = null;

        ColumnIdentifier c = null;

        Term.Raw k = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:748:5: (key= cident '=' t= term ( '+' c= cident )? | key= cident '=' c= cident sig= ( '+' | '-' ) t= term | key= cident '=' c= cident i= INTEGER | key= cident '[' k= term ']' '=' t= term )
            int alt85=4;
            alt85 = dfa85.predict(input);
            switch (alt85) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:748:7: key= cident '=' t= term ( '+' c= cident )?
                    {
                    pushFollow(FOLLOW_cident_in_columnOperation4582);
                    key=cident();

                    state._fsp--;

                    match(input,140,FOLLOW_140_in_columnOperation4584); 
                    pushFollow(FOLLOW_term_in_columnOperation4588);
                    t=term();

                    state._fsp--;

                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:748:29: ( '+' c= cident )?
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( (LA84_0==141) ) {
                        alt84=1;
                    }
                    switch (alt84) {
                        case 1 :
                            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:748:30: '+' c= cident
                            {
                            match(input,141,FOLLOW_141_in_columnOperation4591); 
                            pushFollow(FOLLOW_cident_in_columnOperation4595);
                            c=cident();

                            state._fsp--;


                            }
                            break;

                    }


                              if (c == null)
                              {
                                  addRawUpdate(operations, key, new Operation.SetValue(t));
                              }
                              else
                              {
                                  if (!key.equals(c))
                                      addRecognitionError("Only expressions of the form X = <value> + X are supported.");
                                  addRawUpdate(operations, key, new Operation.Prepend(t));
                              }
                          

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:761:7: key= cident '=' c= cident sig= ( '+' | '-' ) t= term
                    {
                    pushFollow(FOLLOW_cident_in_columnOperation4616);
                    key=cident();

                    state._fsp--;

                    match(input,140,FOLLOW_140_in_columnOperation4618); 
                    pushFollow(FOLLOW_cident_in_columnOperation4622);
                    c=cident();

                    state._fsp--;

                    sig=(Token)input.LT(1);
                    if ( (input.LA(1)>=141 && input.LA(1)<=142) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_term_in_columnOperation4636);
                    t=term();

                    state._fsp--;


                              if (!key.equals(c))
                                  addRecognitionError("Only expressions of the form X = X " + (sig!=null?sig.getText():null) + "<value> are supported.");
                              addRawUpdate(operations, key, (sig!=null?sig.getText():null).equals("+") ? new Operation.Addition(t) : new Operation.Substraction(t));
                          

                    }
                    break;
                case 3 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:767:7: key= cident '=' c= cident i= INTEGER
                    {
                    pushFollow(FOLLOW_cident_in_columnOperation4654);
                    key=cident();

                    state._fsp--;

                    match(input,140,FOLLOW_140_in_columnOperation4656); 
                    pushFollow(FOLLOW_cident_in_columnOperation4660);
                    c=cident();

                    state._fsp--;

                    i=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_columnOperation4664); 

                              // Note that this production *is* necessary because X = X - 3 will in fact be lexed as [ X, '=', X, INTEGER].
                              if (!key.equals(c))
                                  // We don't yet allow a '+' in front of an integer, but we could in the future really, so let's be future-proof in our error message
                                  addRecognitionError("Only expressions of the form X = X " + ((i!=null?i.getText():null).charAt(0) == '-' ? '-' : '+') + " <value> are supported.");
                              addRawUpdate(operations, key, new Operation.Addition(Constants.Literal.integer((i!=null?i.getText():null))));
                          

                    }
                    break;
                case 4 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:775:7: key= cident '[' k= term ']' '=' t= term
                    {
                    pushFollow(FOLLOW_cident_in_columnOperation4682);
                    key=cident();

                    state._fsp--;

                    match(input,134,FOLLOW_134_in_columnOperation4684); 
                    pushFollow(FOLLOW_term_in_columnOperation4688);
                    k=term();

                    state._fsp--;

                    match(input,135,FOLLOW_135_in_columnOperation4690); 
                    match(input,140,FOLLOW_140_in_columnOperation4692); 
                    pushFollow(FOLLOW_term_in_columnOperation4696);
                    t=term();

                    state._fsp--;


                              addRawUpdate(operations, key, new Operation.SetElement(k, t));
                          

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "columnOperation"


    // $ANTLR start "properties"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:781:1: properties[PropertyDefinitions props] : property[props] ( K_AND property[props] )* ;
    public final void properties(PropertyDefinitions props) throws RecognitionException {
        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:782:5: ( property[props] ( K_AND property[props] )* )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:782:7: property[props] ( K_AND property[props] )*
            {
            pushFollow(FOLLOW_property_in_properties4722);
            property(props);

            state._fsp--;

            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:782:23: ( K_AND property[props] )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==K_AND) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:782:24: K_AND property[props]
            	    {
            	    match(input,K_AND,FOLLOW_K_AND_in_properties4726); 
            	    pushFollow(FOLLOW_property_in_properties4728);
            	    property(props);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop86;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "properties"


    // $ANTLR start "property"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:785:1: property[PropertyDefinitions props] : k= cident '=' (simple= propertyValue | map= map_literal ) ;
    public final void property(PropertyDefinitions props) throws RecognitionException {
        ColumnIdentifier k = null;

        String simple = null;

        Maps.Literal map = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:786:5: (k= cident '=' (simple= propertyValue | map= map_literal ) )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:786:7: k= cident '=' (simple= propertyValue | map= map_literal )
            {
            pushFollow(FOLLOW_cident_in_property4751);
            k=cident();

            state._fsp--;

            match(input,140,FOLLOW_140_in_property4753); 
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:786:20: (simple= propertyValue | map= map_literal )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==K_COUNT||LA87_0==INTEGER||(LA87_0>=K_FILTERING && LA87_0<=K_TTL)||LA87_0==K_VALUES||LA87_0==K_TIMESTAMP||LA87_0==K_EXISTS||LA87_0==K_COUNTER||(LA87_0>=K_KEY && LA87_0<=K_CLUSTERING)||LA87_0==K_TYPE||LA87_0==K_LIST||(LA87_0>=K_ALL && LA87_0<=STRING_LITERAL)||(LA87_0>=FLOAT && LA87_0<=HEXNUMBER)||(LA87_0>=K_ASCII && LA87_0<=K_MAP)) ) {
                alt87=1;
            }
            else if ( (LA87_0==139) ) {
                alt87=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:786:21: simple= propertyValue
                    {
                    pushFollow(FOLLOW_propertyValue_in_property4758);
                    simple=propertyValue();

                    state._fsp--;

                     try { props.addProperty(k.toString(), simple); } catch (SyntaxException e) { addRecognitionError(e.getMessage()); } 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:787:24: map= map_literal
                    {
                    pushFollow(FOLLOW_map_literal_in_property4787);
                    map=map_literal();

                    state._fsp--;

                     try { props.addProperty(k.toString(), convertPropertyMap(map)); } catch (SyntaxException e) { addRecognitionError(e.getMessage()); } 

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "property"


    // $ANTLR start "propertyValue"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:790:1: propertyValue returns [String str] : (c= constant | u= unreserved_keyword );
    public final String propertyValue() throws RecognitionException {
        String str = null;

        Constants.Literal c = null;

        String u = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:791:5: (c= constant | u= unreserved_keyword )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==INTEGER||LA88_0==STRING_LITERAL||(LA88_0>=FLOAT && LA88_0<=HEXNUMBER)) ) {
                alt88=1;
            }
            else if ( (LA88_0==K_COUNT||(LA88_0>=K_FILTERING && LA88_0<=K_TTL)||LA88_0==K_VALUES||LA88_0==K_TIMESTAMP||LA88_0==K_EXISTS||LA88_0==K_COUNTER||(LA88_0>=K_KEY && LA88_0<=K_CLUSTERING)||LA88_0==K_TYPE||LA88_0==K_LIST||(LA88_0>=K_ALL && LA88_0<=K_PASSWORD)||(LA88_0>=K_ASCII && LA88_0<=K_MAP)) ) {
                alt88=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }
            switch (alt88) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:791:7: c= constant
                    {
                    pushFollow(FOLLOW_constant_in_propertyValue4815);
                    c=constant();

                    state._fsp--;

                     str = c.getRawText(); 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:792:7: u= unreserved_keyword
                    {
                    pushFollow(FOLLOW_unreserved_keyword_in_propertyValue4837);
                    u=unreserved_keyword();

                    state._fsp--;

                     str = u; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return str;
    }
    // $ANTLR end "propertyValue"


    // $ANTLR start "relationType"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:795:1: relationType returns [Relation.Type op] : ( '=' | '<' | '<=' | '>' | '>=' );
    public final Relation.Type relationType() throws RecognitionException {
        Relation.Type op = null;

        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:796:5: ( '=' | '<' | '<=' | '>' | '>=' )
            int alt89=5;
            switch ( input.LA(1) ) {
            case 140:
                {
                alt89=1;
                }
                break;
            case 143:
                {
                alt89=2;
                }
                break;
            case 144:
                {
                alt89=3;
                }
                break;
            case 145:
                {
                alt89=4;
                }
                break;
            case 146:
                {
                alt89=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }

            switch (alt89) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:796:7: '='
                    {
                    match(input,140,FOLLOW_140_in_relationType4860); 
                     op = Relation.Type.EQ; 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:797:7: '<'
                    {
                    match(input,143,FOLLOW_143_in_relationType4871); 
                     op = Relation.Type.LT; 

                    }
                    break;
                case 3 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:798:7: '<='
                    {
                    match(input,144,FOLLOW_144_in_relationType4882); 
                     op = Relation.Type.LTE; 

                    }
                    break;
                case 4 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:799:7: '>'
                    {
                    match(input,145,FOLLOW_145_in_relationType4892); 
                     op = Relation.Type.GT; 

                    }
                    break;
                case 5 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:800:7: '>='
                    {
                    match(input,146,FOLLOW_146_in_relationType4903); 
                     op = Relation.Type.GTE; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return op;
    }
    // $ANTLR end "relationType"


    // $ANTLR start "relation"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:803:1: relation[List<Relation> clauses] : (name= cident type= relationType t= term | K_TOKEN '(' name1= cident ( ',' namen= cident )* ')' type= relationType t= term | name= cident K_IN '(' f1= term ( ',' fN= term )* ')' );
    public final void relation(List<Relation> clauses) throws RecognitionException {
        ColumnIdentifier name = null;

        Relation.Type type = null;

        Term.Raw t = null;

        ColumnIdentifier name1 = null;

        ColumnIdentifier namen = null;

        Term.Raw f1 = null;

        Term.Raw fN = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:804:5: (name= cident type= relationType t= term | K_TOKEN '(' name1= cident ( ',' namen= cident )* ')' type= relationType t= term | name= cident K_IN '(' f1= term ( ',' fN= term )* ')' )
            int alt92=3;
            alt92 = dfa92.predict(input);
            switch (alt92) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:804:7: name= cident type= relationType t= term
                    {
                    pushFollow(FOLLOW_cident_in_relation4925);
                    name=cident();

                    state._fsp--;

                    pushFollow(FOLLOW_relationType_in_relation4929);
                    type=relationType();

                    state._fsp--;

                    pushFollow(FOLLOW_term_in_relation4933);
                    t=term();

                    state._fsp--;

                     clauses.add(new Relation(name, type, t)); 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:805:7: K_TOKEN '(' name1= cident ( ',' namen= cident )* ')' type= relationType t= term
                    {
                    match(input,K_TOKEN,FOLLOW_K_TOKEN_in_relation4943); 
                     List<ColumnIdentifier> l = new ArrayList<ColumnIdentifier>(); 
                    match(input,130,FOLLOW_130_in_relation4966); 
                    pushFollow(FOLLOW_cident_in_relation4970);
                    name1=cident();

                    state._fsp--;

                     l.add(name1); 
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:807:46: ( ',' namen= cident )*
                    loop90:
                    do {
                        int alt90=2;
                        int LA90_0 = input.LA(1);

                        if ( (LA90_0==132) ) {
                            alt90=1;
                        }


                        switch (alt90) {
                    	case 1 :
                    	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:807:48: ',' namen= cident
                    	    {
                    	    match(input,132,FOLLOW_132_in_relation4976); 
                    	    pushFollow(FOLLOW_cident_in_relation4980);
                    	    namen=cident();

                    	    state._fsp--;

                    	     l.add(namen); 

                    	    }
                    	    break;

                    	default :
                    	    break loop90;
                        }
                    } while (true);

                    match(input,131,FOLLOW_131_in_relation4986); 
                    pushFollow(FOLLOW_relationType_in_relation4998);
                    type=relationType();

                    state._fsp--;

                    pushFollow(FOLLOW_term_in_relation5002);
                    t=term();

                    state._fsp--;


                                for (ColumnIdentifier id : l)
                                    clauses.add(new Relation(id, type, t, true));
                            

                    }
                    break;
                case 3 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:813:7: name= cident K_IN '(' f1= term ( ',' fN= term )* ')'
                    {
                    pushFollow(FOLLOW_cident_in_relation5022);
                    name=cident();

                    state._fsp--;

                    match(input,K_IN,FOLLOW_K_IN_in_relation5024); 
                     Relation rel = Relation.createInRelation(name); 
                    match(input,130,FOLLOW_130_in_relation5035); 
                    pushFollow(FOLLOW_term_in_relation5039);
                    f1=term();

                    state._fsp--;

                     rel.addInValue(f1); 
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:814:44: ( ',' fN= term )*
                    loop91:
                    do {
                        int alt91=2;
                        int LA91_0 = input.LA(1);

                        if ( (LA91_0==132) ) {
                            alt91=1;
                        }


                        switch (alt91) {
                    	case 1 :
                    	    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:814:45: ',' fN= term
                    	    {
                    	    match(input,132,FOLLOW_132_in_relation5044); 
                    	    pushFollow(FOLLOW_term_in_relation5048);
                    	    fN=term();

                    	    state._fsp--;

                    	     rel.addInValue(fN); 

                    	    }
                    	    break;

                    	default :
                    	    break loop91;
                        }
                    } while (true);

                    match(input,131,FOLLOW_131_in_relation5055); 
                     clauses.add(rel); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "relation"


    // $ANTLR start "comparatorType"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:817:1: comparatorType returns [CQL3Type t] : (c= native_type | c= collection_type | s= STRING_LITERAL );
    public final CQL3Type comparatorType() throws RecognitionException {
        CQL3Type t = null;

        Token s=null;
        CQL3Type c = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:818:5: (c= native_type | c= collection_type | s= STRING_LITERAL )
            int alt93=3;
            switch ( input.LA(1) ) {
            case K_TIMESTAMP:
            case K_COUNTER:
            case K_ASCII:
            case K_BIGINT:
            case K_BLOB:
            case K_BOOLEAN:
            case K_DECIMAL:
            case K_DOUBLE:
            case K_FLOAT:
            case K_INET:
            case K_INT:
            case K_TEXT:
            case K_UUID:
            case K_VARCHAR:
            case K_VARINT:
            case K_TIMEUUID:
                {
                alt93=1;
                }
                break;
            case K_SET:
            case K_LIST:
            case K_MAP:
                {
                alt93=2;
                }
                break;
            case STRING_LITERAL:
                {
                alt93=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }

            switch (alt93) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:818:7: c= native_type
                    {
                    pushFollow(FOLLOW_native_type_in_comparatorType5080);
                    c=native_type();

                    state._fsp--;

                     t = c; 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:819:7: c= collection_type
                    {
                    pushFollow(FOLLOW_collection_type_in_comparatorType5096);
                    c=collection_type();

                    state._fsp--;

                     t = c; 

                    }
                    break;
                case 3 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:820:7: s= STRING_LITERAL
                    {
                    s=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_comparatorType5108); 

                            try {
                                t = new CQL3Type.Custom((s!=null?s.getText():null));
                            } catch (SyntaxException e) {
                                addRecognitionError("Cannot parse type " + (s!=null?s.getText():null) + ": " + e.getMessage());
                            } catch (ConfigurationException e) {
                                addRecognitionError("Error setting type " + (s!=null?s.getText():null) + ": " + e.getMessage());
                            }
                          

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return t;
    }
    // $ANTLR end "comparatorType"


    // $ANTLR start "native_type"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:832:1: native_type returns [CQL3Type t] : ( K_ASCII | K_BIGINT | K_BLOB | K_BOOLEAN | K_COUNTER | K_DECIMAL | K_DOUBLE | K_FLOAT | K_INET | K_INT | K_TEXT | K_TIMESTAMP | K_UUID | K_VARCHAR | K_VARINT | K_TIMEUUID );
    public final CQL3Type native_type() throws RecognitionException {
        CQL3Type t = null;

        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:833:5: ( K_ASCII | K_BIGINT | K_BLOB | K_BOOLEAN | K_COUNTER | K_DECIMAL | K_DOUBLE | K_FLOAT | K_INET | K_INT | K_TEXT | K_TIMESTAMP | K_UUID | K_VARCHAR | K_VARINT | K_TIMEUUID )
            int alt94=16;
            switch ( input.LA(1) ) {
            case K_ASCII:
                {
                alt94=1;
                }
                break;
            case K_BIGINT:
                {
                alt94=2;
                }
                break;
            case K_BLOB:
                {
                alt94=3;
                }
                break;
            case K_BOOLEAN:
                {
                alt94=4;
                }
                break;
            case K_COUNTER:
                {
                alt94=5;
                }
                break;
            case K_DECIMAL:
                {
                alt94=6;
                }
                break;
            case K_DOUBLE:
                {
                alt94=7;
                }
                break;
            case K_FLOAT:
                {
                alt94=8;
                }
                break;
            case K_INET:
                {
                alt94=9;
                }
                break;
            case K_INT:
                {
                alt94=10;
                }
                break;
            case K_TEXT:
                {
                alt94=11;
                }
                break;
            case K_TIMESTAMP:
                {
                alt94=12;
                }
                break;
            case K_UUID:
                {
                alt94=13;
                }
                break;
            case K_VARCHAR:
                {
                alt94=14;
                }
                break;
            case K_VARINT:
                {
                alt94=15;
                }
                break;
            case K_TIMEUUID:
                {
                alt94=16;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }

            switch (alt94) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:833:7: K_ASCII
                    {
                    match(input,K_ASCII,FOLLOW_K_ASCII_in_native_type5137); 
                     t = CQL3Type.Native.ASCII; 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:834:7: K_BIGINT
                    {
                    match(input,K_BIGINT,FOLLOW_K_BIGINT_in_native_type5151); 
                     t = CQL3Type.Native.BIGINT; 

                    }
                    break;
                case 3 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:835:7: K_BLOB
                    {
                    match(input,K_BLOB,FOLLOW_K_BLOB_in_native_type5164); 
                     t = CQL3Type.Native.BLOB; 

                    }
                    break;
                case 4 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:836:7: K_BOOLEAN
                    {
                    match(input,K_BOOLEAN,FOLLOW_K_BOOLEAN_in_native_type5179); 
                     t = CQL3Type.Native.BOOLEAN; 

                    }
                    break;
                case 5 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:837:7: K_COUNTER
                    {
                    match(input,K_COUNTER,FOLLOW_K_COUNTER_in_native_type5191); 
                     t = CQL3Type.Native.COUNTER; 

                    }
                    break;
                case 6 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:838:7: K_DECIMAL
                    {
                    match(input,K_DECIMAL,FOLLOW_K_DECIMAL_in_native_type5203); 
                     t = CQL3Type.Native.DECIMAL; 

                    }
                    break;
                case 7 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:839:7: K_DOUBLE
                    {
                    match(input,K_DOUBLE,FOLLOW_K_DOUBLE_in_native_type5215); 
                     t = CQL3Type.Native.DOUBLE; 

                    }
                    break;
                case 8 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:840:7: K_FLOAT
                    {
                    match(input,K_FLOAT,FOLLOW_K_FLOAT_in_native_type5228); 
                     t = CQL3Type.Native.FLOAT; 

                    }
                    break;
                case 9 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:841:7: K_INET
                    {
                    match(input,K_INET,FOLLOW_K_INET_in_native_type5242); 
                     t = CQL3Type.Native.INET;

                    }
                    break;
                case 10 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:842:7: K_INT
                    {
                    match(input,K_INT,FOLLOW_K_INT_in_native_type5257); 
                     t = CQL3Type.Native.INT; 

                    }
                    break;
                case 11 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:843:7: K_TEXT
                    {
                    match(input,K_TEXT,FOLLOW_K_TEXT_in_native_type5273); 
                     t = CQL3Type.Native.TEXT; 

                    }
                    break;
                case 12 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:844:7: K_TIMESTAMP
                    {
                    match(input,K_TIMESTAMP,FOLLOW_K_TIMESTAMP_in_native_type5288); 
                     t = CQL3Type.Native.TIMESTAMP; 

                    }
                    break;
                case 13 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:845:7: K_UUID
                    {
                    match(input,K_UUID,FOLLOW_K_UUID_in_native_type5298); 
                     t = CQL3Type.Native.UUID; 

                    }
                    break;
                case 14 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:846:7: K_VARCHAR
                    {
                    match(input,K_VARCHAR,FOLLOW_K_VARCHAR_in_native_type5313); 
                     t = CQL3Type.Native.VARCHAR; 

                    }
                    break;
                case 15 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:847:7: K_VARINT
                    {
                    match(input,K_VARINT,FOLLOW_K_VARINT_in_native_type5325); 
                     t = CQL3Type.Native.VARINT; 

                    }
                    break;
                case 16 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:848:7: K_TIMEUUID
                    {
                    match(input,K_TIMEUUID,FOLLOW_K_TIMEUUID_in_native_type5338); 
                     t = CQL3Type.Native.TIMEUUID; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return t;
    }
    // $ANTLR end "native_type"


    // $ANTLR start "collection_type"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:851:1: collection_type returns [CQL3Type pt] : ( K_MAP '<' t1= comparatorType ',' t2= comparatorType '>' | K_LIST '<' t= comparatorType '>' | K_SET '<' t= comparatorType '>' );
    public final CQL3Type collection_type() throws RecognitionException {
        CQL3Type pt = null;

        CQL3Type t1 = null;

        CQL3Type t2 = null;

        CQL3Type t = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:852:5: ( K_MAP '<' t1= comparatorType ',' t2= comparatorType '>' | K_LIST '<' t= comparatorType '>' | K_SET '<' t= comparatorType '>' )
            int alt95=3;
            switch ( input.LA(1) ) {
            case K_MAP:
                {
                alt95=1;
                }
                break;
            case K_LIST:
                {
                alt95=2;
                }
                break;
            case K_SET:
                {
                alt95=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }

            switch (alt95) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:852:7: K_MAP '<' t1= comparatorType ',' t2= comparatorType '>'
                    {
                    match(input,K_MAP,FOLLOW_K_MAP_in_collection_type5362); 
                    match(input,143,FOLLOW_143_in_collection_type5365); 
                    pushFollow(FOLLOW_comparatorType_in_collection_type5369);
                    t1=comparatorType();

                    state._fsp--;

                    match(input,132,FOLLOW_132_in_collection_type5371); 
                    pushFollow(FOLLOW_comparatorType_in_collection_type5375);
                    t2=comparatorType();

                    state._fsp--;

                    match(input,145,FOLLOW_145_in_collection_type5377); 
                     try {
                                // if we can't parse either t1 or t2, antlr will "recover" and we may have t1 or t2 null.
                                if (t1 != null && t2 != null)
                                    pt = CQL3Type.Collection.map(t1, t2);
                              } catch (InvalidRequestException e) { addRecognitionError(e.getMessage()); } 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:858:7: K_LIST '<' t= comparatorType '>'
                    {
                    match(input,K_LIST,FOLLOW_K_LIST_in_collection_type5395); 
                    match(input,143,FOLLOW_143_in_collection_type5397); 
                    pushFollow(FOLLOW_comparatorType_in_collection_type5401);
                    t=comparatorType();

                    state._fsp--;

                    match(input,145,FOLLOW_145_in_collection_type5403); 
                     try { if (t != null) pt = CQL3Type.Collection.list(t); } catch (InvalidRequestException e) { addRecognitionError(e.getMessage()); } 

                    }
                    break;
                case 3 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:860:7: K_SET '<' t= comparatorType '>'
                    {
                    match(input,K_SET,FOLLOW_K_SET_in_collection_type5421); 
                    match(input,143,FOLLOW_143_in_collection_type5424); 
                    pushFollow(FOLLOW_comparatorType_in_collection_type5428);
                    t=comparatorType();

                    state._fsp--;

                    match(input,145,FOLLOW_145_in_collection_type5430); 
                     try { if (t != null) pt = CQL3Type.Collection.set(t); } catch (InvalidRequestException e) { addRecognitionError(e.getMessage()); } 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return pt;
    }
    // $ANTLR end "collection_type"

    public static class username_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "username"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:864:1: username : ( IDENT | STRING_LITERAL );
    public final CqlParser.username_return username() throws RecognitionException {
        CqlParser.username_return retval = new CqlParser.username_return();
        retval.start = input.LT(1);

        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:865:5: ( IDENT | STRING_LITERAL )
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:
            {
            if ( input.LA(1)==IDENT||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "username"


    // $ANTLR start "unreserved_keyword"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:869:1: unreserved_keyword returns [String str] : (u= unreserved_function_keyword | k= ( K_TTL | K_COUNT | K_WRITETIME ) );
    public final String unreserved_keyword() throws RecognitionException {
        String str = null;

        Token k=null;
        String u = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:870:5: (u= unreserved_function_keyword | k= ( K_TTL | K_COUNT | K_WRITETIME ) )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==K_FILTERING||LA96_0==K_VALUES||LA96_0==K_TIMESTAMP||LA96_0==K_EXISTS||LA96_0==K_COUNTER||(LA96_0>=K_KEY && LA96_0<=K_CLUSTERING)||LA96_0==K_TYPE||LA96_0==K_LIST||(LA96_0>=K_ALL && LA96_0<=K_PASSWORD)||(LA96_0>=K_ASCII && LA96_0<=K_MAP)) ) {
                alt96=1;
            }
            else if ( (LA96_0==K_COUNT||(LA96_0>=K_WRITETIME && LA96_0<=K_TTL)) ) {
                alt96=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;
            }
            switch (alt96) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:870:7: u= unreserved_function_keyword
                    {
                    pushFollow(FOLLOW_unreserved_function_keyword_in_unreserved_keyword5488);
                    u=unreserved_function_keyword();

                    state._fsp--;

                     str = u; 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:871:7: k= ( K_TTL | K_COUNT | K_WRITETIME )
                    {
                    k=(Token)input.LT(1);
                    if ( input.LA(1)==K_COUNT||(input.LA(1)>=K_WRITETIME && input.LA(1)<=K_TTL) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                     str = (k!=null?k.getText():null); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return str;
    }
    // $ANTLR end "unreserved_keyword"


    // $ANTLR start "unreserved_function_keyword"
    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:874:1: unreserved_function_keyword returns [String str] : (k= ( K_KEY | K_CLUSTERING | K_COMPACT | K_STORAGE | K_TYPE | K_VALUES | K_MAP | K_LIST | K_FILTERING | K_PERMISSION | K_PERMISSIONS | K_KEYSPACES | K_ALL | K_USER | K_USERS | K_SUPERUSER | K_NOSUPERUSER | K_PASSWORD | K_EXISTS ) | t= native_type );
    public final String unreserved_function_keyword() throws RecognitionException {
        String str = null;

        Token k=null;
        CQL3Type t = null;


        try {
            // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:875:5: (k= ( K_KEY | K_CLUSTERING | K_COMPACT | K_STORAGE | K_TYPE | K_VALUES | K_MAP | K_LIST | K_FILTERING | K_PERMISSION | K_PERMISSIONS | K_KEYSPACES | K_ALL | K_USER | K_USERS | K_SUPERUSER | K_NOSUPERUSER | K_PASSWORD | K_EXISTS ) | t= native_type )
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==K_FILTERING||LA97_0==K_VALUES||LA97_0==K_EXISTS||(LA97_0>=K_KEY && LA97_0<=K_CLUSTERING)||LA97_0==K_TYPE||LA97_0==K_LIST||(LA97_0>=K_ALL && LA97_0<=K_PASSWORD)||LA97_0==K_MAP) ) {
                alt97=1;
            }
            else if ( (LA97_0==K_TIMESTAMP||LA97_0==K_COUNTER||(LA97_0>=K_ASCII && LA97_0<=K_TIMEUUID)) ) {
                alt97=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;
            }
            switch (alt97) {
                case 1 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:875:7: k= ( K_KEY | K_CLUSTERING | K_COMPACT | K_STORAGE | K_TYPE | K_VALUES | K_MAP | K_LIST | K_FILTERING | K_PERMISSION | K_PERMISSIONS | K_KEYSPACES | K_ALL | K_USER | K_USERS | K_SUPERUSER | K_NOSUPERUSER | K_PASSWORD | K_EXISTS )
                    {
                    k=(Token)input.LT(1);
                    if ( input.LA(1)==K_FILTERING||input.LA(1)==K_VALUES||input.LA(1)==K_EXISTS||(input.LA(1)>=K_KEY && input.LA(1)<=K_CLUSTERING)||input.LA(1)==K_TYPE||input.LA(1)==K_LIST||(input.LA(1)>=K_ALL && input.LA(1)<=K_PASSWORD)||input.LA(1)==K_MAP ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                     str = (k!=null?k.getText():null); 

                    }
                    break;
                case 2 :
                    // /home/xuchen/Dropbox/d-workspace/cassandra-trunk/src/java/org/apache/cassandra/cql3/Cql.g:895:7: t= native_type
                    {
                    pushFollow(FOLLOW_native_type_in_unreserved_function_keyword5779);
                    t=native_type();

                    state._fsp--;

                     str = t.toString(); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return str;
    }
    // $ANTLR end "unreserved_function_keyword"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA13 dfa13 = new DFA13(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA69 dfa69 = new DFA69(this);
    protected DFA85 dfa85 = new DFA85(this);
    protected DFA92 dfa92 = new DFA92(this);
    static final String DFA2_eotS =
        "\33\uffff";
    static final String DFA2_eofS =
        "\33\uffff";
    static final String DFA2_minS =
        "\1\4\7\uffff\3\45\2\uffff\1\5\15\uffff";
    static final String DFA2_maxS =
        "\1\71\7\uffff\3\102\2\uffff\1\105\15\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\3\uffff\1\20\1\21\1\uffff\1"+
        "\10\1\11\1\12\1\23\1\13\1\14\1\15\1\25\1\16\1\17\1\24\1\26\1\22";
    static final String DFA2_specialS =
        "\33\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\6\1\1\16\uffff\1\2\4\uffff\1\3\4\uffff\1\5\1\4\4\uffff\1"+
            "\10\13\uffff\1\12\2\uffff\1\11\2\uffff\1\7\1\13\1\14\1\15",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\16\1\uffff\1\17\5\uffff\1\20\24\uffff\1\21",
            "\1\22\1\uffff\1\23\5\uffff\1\24\24\uffff\1\25",
            "\1\27\1\uffff\1\26\32\uffff\1\30",
            "",
            "",
            "\1\32\36\uffff\1\32\13\uffff\1\32\2\uffff\1\32\10\uffff\3\32"+
            "\6\uffff\1\31",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "172:1: cqlStatement returns [ParsedStatement stmt] : (st1= selectStatement | st2= insertStatement | st3= updateStatement | st4= batchStatement | st5= deleteStatement | st6= useStatement | st7= truncateStatement | st8= createKeyspaceStatement | st9= createColumnFamilyStatement | st10= createIndexStatement | st11= dropKeyspaceStatement | st12= dropColumnFamilyStatement | st13= dropIndexStatement | st14= alterTableStatement | st15= alterKeyspaceStatement | st16= grantStatement | st17= revokeStatement | st18= listPermissionsStatement | st19= createUserStatement | st20= alterUserStatement | st21= dropUserStatement | st22= listUsersStatement );";
        }
    }
    static final String DFA13_eotS =
        "\31\uffff";
    static final String DFA13_eofS =
        "\31\uffff";
    static final String DFA13_minS =
        "\1\6\1\7\1\uffff\23\7\3\uffff";
    static final String DFA13_maxS =
        "\1\137\1\u0084\1\uffff\23\u0084\3\uffff";
    static final String DFA13_acceptS =
        "\2\uffff\1\1\23\uffff\1\4\1\2\1\3";
    static final String DFA13_specialS =
        "\31\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\2\7\uffff\1\3\1\24\1\25\5\uffff\1\3\1\uffff\1\17\4\uffff"+
            "\1\3\3\uffff\1\10\7\uffff\4\3\1\uffff\1\1\2\uffff\1\3\7\uffff"+
            "\1\3\4\uffff\11\3\1\uffff\1\2\6\uffff\1\26\1\uffff\1\4\1\5\1"+
            "\6\1\7\1\11\1\12\1\13\1\14\1\15\1\16\1\20\1\21\1\22\1\23\1\3",
            "\1\2\172\uffff\1\26\2\2",
            "",
            "\1\2\172\uffff\1\26\2\2",
            "\1\2\172\uffff\1\26\2\2",
            "\1\2\172\uffff\1\26\2\2",
            "\1\2\172\uffff\1\26\2\2",
            "\1\2\172\uffff\1\26\2\2",
            "\1\2\172\uffff\1\26\2\2",
            "\1\2\172\uffff\1\26\2\2",
            "\1\2\172\uffff\1\26\2\2",
            "\1\2\172\uffff\1\26\2\2",
            "\1\2\172\uffff\1\26\2\2",
            "\1\2\172\uffff\1\26\2\2",
            "\1\2\172\uffff\1\26\2\2",
            "\1\2\172\uffff\1\26\2\2",
            "\1\2\172\uffff\1\26\2\2",
            "\1\2\172\uffff\1\26\2\2",
            "\1\2\172\uffff\1\26\2\2",
            "\1\2\172\uffff\1\26\2\2",
            "\1\2\172\uffff\1\27\2\2",
            "\1\2\172\uffff\1\30\2\2",
            "",
            "",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "245:1: selector returns [RawSelector s] : (c= cident | K_WRITETIME '(' c= cident ')' | K_TTL '(' c= cident ')' | f= functionName args= selectionFunctionArgs );";
        }
    }
    static final String DFA34_eotS =
        "\27\uffff";
    static final String DFA34_eofS =
        "\27\uffff";
    static final String DFA34_minS =
        "\1\6\24\7\2\uffff";
    static final String DFA34_maxS =
        "\1\137\24\u0086\2\uffff";
    static final String DFA34_acceptS =
        "\25\uffff\1\1\1\2";
    static final String DFA34_specialS =
        "\27\uffff}>";
    static final String[] DFA34_transitionS = {
            "\1\24\7\uffff\1\3\2\24\5\uffff\1\3\1\uffff\1\17\4\uffff\1\3"+
            "\3\uffff\1\10\7\uffff\4\3\1\uffff\1\1\2\uffff\1\3\7\uffff\1"+
            "\3\4\uffff\11\3\1\uffff\1\2\10\uffff\1\4\1\5\1\6\1\7\1\11\1"+
            "\12\1\13\1\14\1\15\1\16\1\20\1\21\1\22\1\23\1\3",
            "\1\25\174\uffff\1\25\1\uffff\1\26",
            "\1\25\174\uffff\1\25\1\uffff\1\26",
            "\1\25\174\uffff\1\25\1\uffff\1\26",
            "\1\25\174\uffff\1\25\1\uffff\1\26",
            "\1\25\174\uffff\1\25\1\uffff\1\26",
            "\1\25\174\uffff\1\25\1\uffff\1\26",
            "\1\25\174\uffff\1\25\1\uffff\1\26",
            "\1\25\174\uffff\1\25\1\uffff\1\26",
            "\1\25\174\uffff\1\25\1\uffff\1\26",
            "\1\25\174\uffff\1\25\1\uffff\1\26",
            "\1\25\174\uffff\1\25\1\uffff\1\26",
            "\1\25\174\uffff\1\25\1\uffff\1\26",
            "\1\25\174\uffff\1\25\1\uffff\1\26",
            "\1\25\174\uffff\1\25\1\uffff\1\26",
            "\1\25\174\uffff\1\25\1\uffff\1\26",
            "\1\25\174\uffff\1\25\1\uffff\1\26",
            "\1\25\174\uffff\1\25\1\uffff\1\26",
            "\1\25\174\uffff\1\25\1\uffff\1\26",
            "\1\25\174\uffff\1\25\1\uffff\1\26",
            "\1\25\174\uffff\1\25\1\uffff\1\26",
            "",
            ""
    };

    static final short[] DFA34_eot = DFA.unpackEncodedString(DFA34_eotS);
    static final short[] DFA34_eof = DFA.unpackEncodedString(DFA34_eofS);
    static final char[] DFA34_min = DFA.unpackEncodedStringToUnsignedChars(DFA34_minS);
    static final char[] DFA34_max = DFA.unpackEncodedStringToUnsignedChars(DFA34_maxS);
    static final short[] DFA34_accept = DFA.unpackEncodedString(DFA34_acceptS);
    static final short[] DFA34_special = DFA.unpackEncodedString(DFA34_specialS);
    static final short[][] DFA34_transition;

    static {
        int numStates = DFA34_transitionS.length;
        DFA34_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA34_transition[i] = DFA.unpackEncodedString(DFA34_transitionS[i]);
        }
    }

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = DFA34_eot;
            this.eof = DFA34_eof;
            this.min = DFA34_min;
            this.max = DFA34_max;
            this.accept = DFA34_accept;
            this.special = DFA34_special;
            this.transition = DFA34_transition;
        }
        public String getDescription() {
            return "372:1: deleteOp returns [Operation.RawDeletion op] : (c= cident | c= cident '[' t= term ']' );";
        }
    }
    static final String DFA69_eotS =
        "\27\uffff";
    static final String DFA69_eofS =
        "\1\uffff\24\26\2\uffff";
    static final String DFA69_minS =
        "\1\6\24\7\2\uffff";
    static final String DFA69_maxS =
        "\1\137\24\u0088\2\uffff";
    static final String DFA69_acceptS =
        "\25\uffff\1\1\1\2";
    static final String DFA69_specialS =
        "\27\uffff}>";
    static final String[] DFA69_transitionS = {
            "\1\24\7\uffff\1\3\2\24\5\uffff\1\3\1\uffff\1\17\4\uffff\1\3"+
            "\3\uffff\1\10\7\uffff\4\3\1\uffff\1\1\2\uffff\1\3\7\uffff\1"+
            "\3\4\uffff\11\3\1\uffff\1\2\10\uffff\1\4\1\5\1\6\1\7\1\11\1"+
            "\12\1\13\1\14\1\15\1\16\1\20\1\21\1\22\1\23\1\3",
            "\3\26\1\uffff\1\26\1\uffff\1\26\11\uffff\1\26\2\uffff\1\26"+
            "\13\uffff\1\26\11\uffff\1\26\1\uffff\4\26\4\uffff\2\26\105\uffff"+
            "\2\26\5\uffff\1\25",
            "\3\26\1\uffff\1\26\1\uffff\1\26\11\uffff\1\26\2\uffff\1\26"+
            "\13\uffff\1\26\11\uffff\1\26\1\uffff\4\26\4\uffff\2\26\105\uffff"+
            "\2\26\5\uffff\1\25",
            "\3\26\1\uffff\1\26\1\uffff\1\26\11\uffff\1\26\2\uffff\1\26"+
            "\13\uffff\1\26\11\uffff\1\26\1\uffff\4\26\4\uffff\2\26\105\uffff"+
            "\2\26\5\uffff\1\25",
            "\3\26\1\uffff\1\26\1\uffff\1\26\11\uffff\1\26\2\uffff\1\26"+
            "\13\uffff\1\26\11\uffff\1\26\1\uffff\4\26\4\uffff\2\26\105\uffff"+
            "\2\26\5\uffff\1\25",
            "\3\26\1\uffff\1\26\1\uffff\1\26\11\uffff\1\26\2\uffff\1\26"+
            "\13\uffff\1\26\11\uffff\1\26\1\uffff\4\26\4\uffff\2\26\105\uffff"+
            "\2\26\5\uffff\1\25",
            "\3\26\1\uffff\1\26\1\uffff\1\26\11\uffff\1\26\2\uffff\1\26"+
            "\13\uffff\1\26\11\uffff\1\26\1\uffff\4\26\4\uffff\2\26\105\uffff"+
            "\2\26\5\uffff\1\25",
            "\3\26\1\uffff\1\26\1\uffff\1\26\11\uffff\1\26\2\uffff\1\26"+
            "\13\uffff\1\26\11\uffff\1\26\1\uffff\4\26\4\uffff\2\26\105\uffff"+
            "\2\26\5\uffff\1\25",
            "\3\26\1\uffff\1\26\1\uffff\1\26\11\uffff\1\26\2\uffff\1\26"+
            "\13\uffff\1\26\11\uffff\1\26\1\uffff\4\26\4\uffff\2\26\105\uffff"+
            "\2\26\5\uffff\1\25",
            "\3\26\1\uffff\1\26\1\uffff\1\26\11\uffff\1\26\2\uffff\1\26"+
            "\13\uffff\1\26\11\uffff\1\26\1\uffff\4\26\4\uffff\2\26\105\uffff"+
            "\2\26\5\uffff\1\25",
            "\3\26\1\uffff\1\26\1\uffff\1\26\11\uffff\1\26\2\uffff\1\26"+
            "\13\uffff\1\26\11\uffff\1\26\1\uffff\4\26\4\uffff\2\26\105\uffff"+
            "\2\26\5\uffff\1\25",
            "\3\26\1\uffff\1\26\1\uffff\1\26\11\uffff\1\26\2\uffff\1\26"+
            "\13\uffff\1\26\11\uffff\1\26\1\uffff\4\26\4\uffff\2\26\105\uffff"+
            "\2\26\5\uffff\1\25",
            "\3\26\1\uffff\1\26\1\uffff\1\26\11\uffff\1\26\2\uffff\1\26"+
            "\13\uffff\1\26\11\uffff\1\26\1\uffff\4\26\4\uffff\2\26\105\uffff"+
            "\2\26\5\uffff\1\25",
            "\3\26\1\uffff\1\26\1\uffff\1\26\11\uffff\1\26\2\uffff\1\26"+
            "\13\uffff\1\26\11\uffff\1\26\1\uffff\4\26\4\uffff\2\26\105\uffff"+
            "\2\26\5\uffff\1\25",
            "\3\26\1\uffff\1\26\1\uffff\1\26\11\uffff\1\26\2\uffff\1\26"+
            "\13\uffff\1\26\11\uffff\1\26\1\uffff\4\26\4\uffff\2\26\105\uffff"+
            "\2\26\5\uffff\1\25",
            "\3\26\1\uffff\1\26\1\uffff\1\26\11\uffff\1\26\2\uffff\1\26"+
            "\13\uffff\1\26\11\uffff\1\26\1\uffff\4\26\4\uffff\2\26\105\uffff"+
            "\2\26\5\uffff\1\25",
            "\3\26\1\uffff\1\26\1\uffff\1\26\11\uffff\1\26\2\uffff\1\26"+
            "\13\uffff\1\26\11\uffff\1\26\1\uffff\4\26\4\uffff\2\26\105\uffff"+
            "\2\26\5\uffff\1\25",
            "\3\26\1\uffff\1\26\1\uffff\1\26\11\uffff\1\26\2\uffff\1\26"+
            "\13\uffff\1\26\11\uffff\1\26\1\uffff\4\26\4\uffff\2\26\105\uffff"+
            "\2\26\5\uffff\1\25",
            "\3\26\1\uffff\1\26\1\uffff\1\26\11\uffff\1\26\2\uffff\1\26"+
            "\13\uffff\1\26\11\uffff\1\26\1\uffff\4\26\4\uffff\2\26\105\uffff"+
            "\2\26\5\uffff\1\25",
            "\3\26\1\uffff\1\26\1\uffff\1\26\11\uffff\1\26\2\uffff\1\26"+
            "\13\uffff\1\26\11\uffff\1\26\1\uffff\4\26\4\uffff\2\26\105\uffff"+
            "\2\26\5\uffff\1\25",
            "\3\26\1\uffff\1\26\1\uffff\1\26\11\uffff\1\26\2\uffff\1\26"+
            "\13\uffff\1\26\11\uffff\1\26\1\uffff\4\26\4\uffff\2\26\105\uffff"+
            "\2\26\5\uffff\1\25",
            "",
            ""
    };

    static final short[] DFA69_eot = DFA.unpackEncodedString(DFA69_eotS);
    static final short[] DFA69_eof = DFA.unpackEncodedString(DFA69_eofS);
    static final char[] DFA69_min = DFA.unpackEncodedStringToUnsignedChars(DFA69_minS);
    static final char[] DFA69_max = DFA.unpackEncodedStringToUnsignedChars(DFA69_maxS);
    static final short[] DFA69_accept = DFA.unpackEncodedString(DFA69_acceptS);
    static final short[] DFA69_special = DFA.unpackEncodedString(DFA69_specialS);
    static final short[][] DFA69_transition;

    static {
        int numStates = DFA69_transitionS.length;
        DFA69_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA69_transition[i] = DFA.unpackEncodedString(DFA69_transitionS[i]);
        }
    }

    class DFA69 extends DFA {

        public DFA69(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 69;
            this.eot = DFA69_eot;
            this.eof = DFA69_eof;
            this.min = DFA69_min;
            this.max = DFA69_max;
            this.accept = DFA69_accept;
            this.special = DFA69_special;
            this.transition = DFA69_transition;
        }
        public String getDescription() {
            return "673:7: ( cfOrKsName[name, true] '.' )?";
        }
    }
    static final String DFA85_eotS =
        "\56\uffff";
    static final String DFA85_eofS =
        "\56\uffff";
    static final String DFA85_minS =
        "\1\6\24\u0086\1\6\2\uffff\24\14\2\uffff";
    static final String DFA85_maxS =
        "\1\137\24\u008c\1\u008b\2\uffff\24\u008e\2\uffff";
    static final String DFA85_acceptS =
        "\26\uffff\1\4\1\1\24\uffff\1\3\1\2";
    static final String DFA85_specialS =
        "\56\uffff}>";
    static final String[] DFA85_transitionS = {
            "\1\24\7\uffff\1\3\2\24\5\uffff\1\3\1\uffff\1\17\4\uffff\1\3"+
            "\3\uffff\1\10\7\uffff\4\3\1\uffff\1\1\2\uffff\1\3\7\uffff\1"+
            "\3\4\uffff\11\3\1\uffff\1\2\10\uffff\1\4\1\5\1\6\1\7\1\11\1"+
            "\12\1\13\1\14\1\15\1\16\1\20\1\21\1\22\1\23\1\3",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\53\5\uffff\1\27\1\uffff\1\31\2\53\5\uffff\1\31\1\uffff\1"+
            "\45\4\uffff\1\31\3\uffff\1\36\7\uffff\4\31\1\uffff\1\30\2\uffff"+
            "\1\31\7\uffff\1\31\4\uffff\11\31\1\27\1\52\7\27\1\uffff\1\32"+
            "\1\33\1\34\1\35\1\37\1\40\1\41\1\42\1\43\1\44\1\46\1\47\1\50"+
            "\1\51\1\31\42\uffff\1\27\3\uffff\1\27\4\uffff\1\27",
            "",
            "",
            "\1\54\165\uffff\1\27\12\uffff\2\55",
            "\1\54\165\uffff\1\27\12\uffff\2\55",
            "\1\54\165\uffff\1\27\12\uffff\2\55",
            "\1\54\165\uffff\1\27\12\uffff\2\55",
            "\1\54\165\uffff\1\27\12\uffff\2\55",
            "\1\54\165\uffff\1\27\12\uffff\2\55",
            "\1\54\165\uffff\1\27\12\uffff\2\55",
            "\1\54\165\uffff\1\27\12\uffff\2\55",
            "\1\54\165\uffff\1\27\12\uffff\2\55",
            "\1\54\165\uffff\1\27\12\uffff\2\55",
            "\1\54\165\uffff\1\27\12\uffff\2\55",
            "\1\54\165\uffff\1\27\12\uffff\2\55",
            "\1\54\165\uffff\1\27\12\uffff\2\55",
            "\1\54\165\uffff\1\27\12\uffff\2\55",
            "\1\54\165\uffff\1\27\12\uffff\2\55",
            "\1\54\165\uffff\1\27\12\uffff\2\55",
            "\1\54\165\uffff\1\27\12\uffff\2\55",
            "\1\54\165\uffff\1\27\12\uffff\2\55",
            "\1\54\u0080\uffff\2\55",
            "\1\54\u0080\uffff\2\55",
            "",
            ""
    };

    static final short[] DFA85_eot = DFA.unpackEncodedString(DFA85_eotS);
    static final short[] DFA85_eof = DFA.unpackEncodedString(DFA85_eofS);
    static final char[] DFA85_min = DFA.unpackEncodedStringToUnsignedChars(DFA85_minS);
    static final char[] DFA85_max = DFA.unpackEncodedStringToUnsignedChars(DFA85_maxS);
    static final short[] DFA85_accept = DFA.unpackEncodedString(DFA85_acceptS);
    static final short[] DFA85_special = DFA.unpackEncodedString(DFA85_specialS);
    static final short[][] DFA85_transition;

    static {
        int numStates = DFA85_transitionS.length;
        DFA85_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA85_transition[i] = DFA.unpackEncodedString(DFA85_transitionS[i]);
        }
    }

    class DFA85 extends DFA {

        public DFA85(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 85;
            this.eot = DFA85_eot;
            this.eof = DFA85_eof;
            this.min = DFA85_min;
            this.max = DFA85_max;
            this.accept = DFA85_accept;
            this.special = DFA85_special;
            this.transition = DFA85_transition;
        }
        public String getDescription() {
            return "747:1: columnOperation[List<Pair<ColumnIdentifier, Operation.RawUpdate>> operations] : (key= cident '=' t= term ( '+' c= cident )? | key= cident '=' c= cident sig= ( '+' | '-' ) t= term | key= cident '=' c= cident i= INTEGER | key= cident '[' k= term ']' '=' t= term );";
        }
    }
    static final String DFA92_eotS =
        "\30\uffff";
    static final String DFA92_eofS =
        "\30\uffff";
    static final String DFA92_minS =
        "\1\6\24\120\3\uffff";
    static final String DFA92_maxS =
        "\1\137\24\u0092\3\uffff";
    static final String DFA92_acceptS =
        "\25\uffff\1\2\1\1\1\3";
    static final String DFA92_specialS =
        "\30\uffff}>";
    static final String[] DFA92_transitionS = {
            "\1\24\7\uffff\1\3\2\24\5\uffff\1\3\1\uffff\1\17\4\uffff\1\3"+
            "\3\uffff\1\10\7\uffff\4\3\1\uffff\1\1\2\uffff\1\3\7\uffff\1"+
            "\3\4\uffff\11\3\1\uffff\1\2\6\uffff\1\25\1\uffff\1\4\1\5\1\6"+
            "\1\7\1\11\1\12\1\13\1\14\1\15\1\16\1\20\1\21\1\22\1\23\1\3",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "",
            "",
            ""
    };

    static final short[] DFA92_eot = DFA.unpackEncodedString(DFA92_eotS);
    static final short[] DFA92_eof = DFA.unpackEncodedString(DFA92_eofS);
    static final char[] DFA92_min = DFA.unpackEncodedStringToUnsignedChars(DFA92_minS);
    static final char[] DFA92_max = DFA.unpackEncodedStringToUnsignedChars(DFA92_maxS);
    static final short[] DFA92_accept = DFA.unpackEncodedString(DFA92_acceptS);
    static final short[] DFA92_special = DFA.unpackEncodedString(DFA92_specialS);
    static final short[][] DFA92_transition;

    static {
        int numStates = DFA92_transitionS.length;
        DFA92_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA92_transition[i] = DFA.unpackEncodedString(DFA92_transitionS[i]);
        }
    }

    class DFA92 extends DFA {

        public DFA92(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 92;
            this.eot = DFA92_eot;
            this.eof = DFA92_eof;
            this.min = DFA92_min;
            this.max = DFA92_max;
            this.accept = DFA92_accept;
            this.special = DFA92_special;
            this.transition = DFA92_transition;
        }
        public String getDescription() {
            return "803:1: relation[List<Relation> clauses] : (name= cident type= relationType t= term | K_TOKEN '(' name1= cident ( ',' namen= cident )* ')' type= relationType t= term | name= cident K_IN '(' f1= term ( ',' fN= term )* ')' );";
        }
    }
 

    public static final BitSet FOLLOW_cqlStatement_in_query72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_query75 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_EOF_in_query79 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selectStatement_in_cqlStatement113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insertStatement_in_cqlStatement138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_updateStatement_in_cqlStatement163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_batchStatement_in_cqlStatement188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteStatement_in_cqlStatement214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_useStatement_in_cqlStatement239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_truncateStatement_in_cqlStatement267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_createKeyspaceStatement_in_cqlStatement290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_createColumnFamilyStatement_in_cqlStatement307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_createIndexStatement_in_cqlStatement319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dropKeyspaceStatement_in_cqlStatement338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dropColumnFamilyStatement_in_cqlStatement356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dropIndexStatement_in_cqlStatement370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alterTableStatement_in_cqlStatement391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alterKeyspaceStatement_in_cqlStatement411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_grantStatement_in_cqlStatement428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_revokeStatement_in_cqlStatement453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listPermissionsStatement_in_cqlStatement477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_createUserStatement_in_cqlStatement492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alterUserStatement_in_cqlStatement512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dropUserStatement_in_cqlStatement533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listUsersStatement_in_cqlStatement555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_USE_in_useStatement589 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_keyspaceName_in_useStatement593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_SELECT_in_selectStatement627 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE817FL,0x0000000000000020L});
    public static final BitSet FOLLOW_selectClause_in_selectStatement633 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_K_COUNT_in_selectStatement638 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_130_in_selectStatement640 = new BitSet(new long[]{0x0000000000001000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_selectCountClause_in_selectStatement644 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_131_in_selectStatement646 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_K_FROM_in_selectStatement659 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_columnFamilyName_in_selectStatement663 = new BitSet(new long[]{0x0000000000002B02L});
    public static final BitSet FOLLOW_K_WHERE_in_selectStatement673 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE817FL});
    public static final BitSet FOLLOW_whereClause_in_selectStatement677 = new BitSet(new long[]{0x0000000000002A02L});
    public static final BitSet FOLLOW_K_ORDER_in_selectStatement690 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_K_BY_in_selectStatement692 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_orderByClause_in_selectStatement694 = new BitSet(new long[]{0x0000000000002802L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_132_in_selectStatement699 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_orderByClause_in_selectStatement701 = new BitSet(new long[]{0x0000000000002802L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_K_LIMIT_in_selectStatement718 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_INTEGER_in_selectStatement722 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_K_ALLOW_in_selectStatement737 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_K_FILTERING_in_selectStatement739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selector_in_selectClause776 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_132_in_selectClause781 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE817FL});
    public static final BitSet FOLLOW_selector_in_selectClause785 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_133_in_selectClause797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_selectionFunctionArgs820 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_131_in_selectionFunctionArgs822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_selectionFunctionArgs832 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE817FL});
    public static final BitSet FOLLOW_selector_in_selectionFunctionArgs836 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_132_in_selectionFunctionArgs852 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE817FL});
    public static final BitSet FOLLOW_selector_in_selectionFunctionArgs856 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_131_in_selectionFunctionArgs870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_selector895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_WRITETIME_in_selector938 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_130_in_selector940 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_cident_in_selector944 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_131_in_selector946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TTL_in_selector969 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_130_in_selector977 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_cident_in_selector981 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_131_in_selector983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionName_in_selector1008 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_selectionFunctionArgs_in_selector1012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_133_in_selectCountClause1035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_selectCountClause1057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relation_in_whereClause1093 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_K_AND_in_whereClause1097 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE817FL});
    public static final BitSet FOLLOW_relation_in_whereClause1099 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_cident_in_orderByClause1130 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_K_ASC_in_orderByClause1135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DESC_in_orderByClause1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_INSERT_in_insertStatement1177 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_K_INTO_in_insertStatement1179 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_columnFamilyName_in_insertStatement1183 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_130_in_insertStatement1195 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_cident_in_insertStatement1199 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_132_in_insertStatement1206 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_cident_in_insertStatement1210 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_131_in_insertStatement1217 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_K_VALUES_in_insertStatement1227 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_130_in_insertStatement1239 = new BitSet(new long[]{0xC2025E022141D040L,0x00000000FFFEFFFFL,0x0000000000000844L});
    public static final BitSet FOLLOW_term_in_insertStatement1243 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_132_in_insertStatement1249 = new BitSet(new long[]{0xC2025E022141D040L,0x00000000FFFEFFFFL,0x0000000000000844L});
    public static final BitSet FOLLOW_term_in_insertStatement1253 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_131_in_insertStatement1260 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_usingClause_in_insertStatement1272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_USING_in_usingClause1302 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_usingClauseObjective_in_usingClause1304 = new BitSet(new long[]{0x0000000001030002L});
    public static final BitSet FOLLOW_K_AND_in_usingClause1309 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_usingClauseObjective_in_usingClause1312 = new BitSet(new long[]{0x0000000001030002L});
    public static final BitSet FOLLOW_K_USING_in_usingClauseDelete1334 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_usingClauseDeleteObjective_in_usingClauseDelete1336 = new BitSet(new long[]{0x0000000001020002L});
    public static final BitSet FOLLOW_K_AND_in_usingClauseDelete1341 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_usingClauseDeleteObjective_in_usingClauseDelete1344 = new BitSet(new long[]{0x0000000001020002L});
    public static final BitSet FOLLOW_K_TIMESTAMP_in_usingClauseDeleteObjective1366 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_INTEGER_in_usingClauseDeleteObjective1370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_usingClauseDeleteObjective_in_usingClauseObjective1390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TTL_in_usingClauseObjective1399 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_INTEGER_in_usingClauseObjective1403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_UPDATE_in_updateStatement1437 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_columnFamilyName_in_updateStatement1441 = new BitSet(new long[]{0x0000000004800000L});
    public static final BitSet FOLLOW_usingClause_in_updateStatement1451 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_K_SET_in_updateStatement1463 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_columnOperation_in_updateStatement1465 = new BitSet(new long[]{0x0000000000000100L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_132_in_updateStatement1469 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_columnOperation_in_updateStatement1471 = new BitSet(new long[]{0x0000000000000100L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_K_WHERE_in_updateStatement1482 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE817FL});
    public static final BitSet FOLLOW_whereClause_in_updateStatement1486 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_K_IF_in_updateStatement1496 = new BitSet(new long[]{0xC2025E023141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_K_NOT_in_updateStatement1499 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_K_EXISTS_in_updateStatement1501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_updateCondition_in_updateStatement1509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_columnOperation_in_updateCondition1551 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_K_AND_in_updateCondition1556 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_columnOperation_in_updateCondition1558 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_K_DELETE_in_deleteStatement1594 = new BitSet(new long[]{0xC2025E022141C0C0L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_deleteSelection_in_deleteStatement1600 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_K_FROM_in_deleteStatement1613 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_columnFamilyName_in_deleteStatement1617 = new BitSet(new long[]{0x0000000000800100L});
    public static final BitSet FOLLOW_usingClauseDelete_in_deleteStatement1627 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_K_WHERE_in_deleteStatement1639 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE817FL});
    public static final BitSet FOLLOW_whereClause_in_deleteStatement1643 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_K_IF_in_deleteStatement1653 = new BitSet(new long[]{0xC2025E023141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_updateCondition_in_deleteStatement1657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteOp_in_deleteSelection1703 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_132_in_deleteSelection1718 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_deleteOp_in_deleteSelection1722 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_cident_in_deleteOp1749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_deleteOp1776 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_134_in_deleteOp1778 = new BitSet(new long[]{0xC2025E022141D040L,0x00000000FFFEFFFFL,0x0000000000000844L});
    public static final BitSet FOLLOW_term_in_deleteOp1782 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_135_in_deleteOp1784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_BEGIN_in_batchStatement1818 = new BitSet(new long[]{0x0000000700000000L});
    public static final BitSet FOLLOW_K_UNLOGGED_in_batchStatement1828 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_K_COUNTER_in_batchStatement1834 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_K_BATCH_in_batchStatement1847 = new BitSet(new long[]{0x0000000042900000L});
    public static final BitSet FOLLOW_usingClause_in_batchStatement1851 = new BitSet(new long[]{0x0000000042900000L});
    public static final BitSet FOLLOW_batchStatementObjective_in_batchStatement1869 = new BitSet(new long[]{0x0000000842900000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_batchStatement1871 = new BitSet(new long[]{0x0000000842900000L});
    public static final BitSet FOLLOW_batchStatementObjective_in_batchStatement1880 = new BitSet(new long[]{0x0000000842900000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_batchStatement1882 = new BitSet(new long[]{0x0000000842900000L});
    public static final BitSet FOLLOW_K_APPLY_in_batchStatement1896 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_K_BATCH_in_batchStatement1898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insertStatement_in_batchStatementObjective1929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_updateStatement_in_batchStatementObjective1942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteStatement_in_batchStatementObjective1955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_CREATE_in_createKeyspaceStatement1990 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_K_KEYSPACE_in_createKeyspaceStatement1992 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_keyspaceName_in_createKeyspaceStatement1996 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_K_WITH_in_createKeyspaceStatement2004 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_properties_in_createKeyspaceStatement2006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_CREATE_in_createColumnFamilyStatement2032 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_K_COLUMNFAMILY_in_createColumnFamilyStatement2034 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_columnFamilyName_in_createColumnFamilyStatement2038 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_cfamDefinition_in_createColumnFamilyStatement2048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_cfamDefinition2067 = new BitSet(new long[]{0xC2025F022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_cfamColumns_in_cfamDefinition2069 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_132_in_cfamDefinition2074 = new BitSet(new long[]{0xC2025F022141C040L,0x00000000FFFE017FL,0x0000000000000018L});
    public static final BitSet FOLLOW_cfamColumns_in_cfamDefinition2076 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_131_in_cfamDefinition2083 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_K_WITH_in_cfamDefinition2093 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_cfamProperty_in_cfamDefinition2095 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_K_AND_in_cfamDefinition2100 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_cfamProperty_in_cfamDefinition2102 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_cident_in_cfamColumns2128 = new BitSet(new long[]{0xC2021E0225404000L,0x00000000FFFE00FFL});
    public static final BitSet FOLLOW_comparatorType_in_cfamColumns2132 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_K_PRIMARY_in_cfamColumns2137 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_K_KEY_in_cfamColumns2139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_PRIMARY_in_cfamColumns2151 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_K_KEY_in_cfamColumns2153 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_130_in_cfamColumns2155 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL,0x0000000000000004L});
    public static final BitSet FOLLOW_pkDef_in_cfamColumns2157 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_132_in_cfamColumns2161 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_cident_in_cfamColumns2165 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_131_in_cfamColumns2172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_pkDef2192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_pkDef2202 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_cident_in_pkDef2208 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_132_in_pkDef2214 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_cident_in_pkDef2218 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_131_in_pkDef2225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_property_in_cfamProperty2245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_COMPACT_in_cfamProperty2254 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_K_STORAGE_in_cfamProperty2256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_CLUSTERING_in_cfamProperty2266 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_K_ORDER_in_cfamProperty2268 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_K_BY_in_cfamProperty2270 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_130_in_cfamProperty2272 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_cfamOrdering_in_cfamProperty2274 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_132_in_cfamProperty2278 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_cfamOrdering_in_cfamProperty2280 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_131_in_cfamProperty2285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_cfamOrdering2313 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_K_ASC_in_cfamOrdering2316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DESC_in_cfamOrdering2320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_CREATE_in_createIndexStatement2349 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_K_INDEX_in_createIndexStatement2351 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_IDENT_in_createIndexStatement2356 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_K_ON_in_createIndexStatement2360 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_columnFamilyName_in_createIndexStatement2364 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_130_in_createIndexStatement2366 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_cident_in_createIndexStatement2370 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_131_in_createIndexStatement2372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_ALTER_in_alterKeyspaceStatement2412 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_K_KEYSPACE_in_alterKeyspaceStatement2414 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_keyspaceName_in_alterKeyspaceStatement2418 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_K_WITH_in_alterKeyspaceStatement2428 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_properties_in_alterKeyspaceStatement2430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_ALTER_in_alterTableStatement2466 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_K_COLUMNFAMILY_in_alterTableStatement2468 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_columnFamilyName_in_alterTableStatement2472 = new BitSet(new long[]{0x001D004000000000L});
    public static final BitSet FOLLOW_K_ALTER_in_alterTableStatement2486 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_cident_in_alterTableStatement2490 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_K_TYPE_in_alterTableStatement2492 = new BitSet(new long[]{0xC2021E0225404000L,0x00000000FFFE00FFL});
    public static final BitSet FOLLOW_comparatorType_in_alterTableStatement2496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_ADD_in_alterTableStatement2512 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_cident_in_alterTableStatement2518 = new BitSet(new long[]{0xC2021E0225404000L,0x00000000FFFE00FFL});
    public static final BitSet FOLLOW_comparatorType_in_alterTableStatement2522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DROP_in_alterTableStatement2545 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_cident_in_alterTableStatement2550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_WITH_in_alterTableStatement2590 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_properties_in_alterTableStatement2593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_RENAME_in_alterTableStatement2626 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_cident_in_alterTableStatement2680 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_K_TO_in_alterTableStatement2682 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_cident_in_alterTableStatement2686 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_K_AND_in_alterTableStatement2707 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_cident_in_alterTableStatement2711 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_K_TO_in_alterTableStatement2713 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_cident_in_alterTableStatement2717 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_K_DROP_in_dropKeyspaceStatement2763 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_K_KEYSPACE_in_dropKeyspaceStatement2765 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_keyspaceName_in_dropKeyspaceStatement2769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DROP_in_dropColumnFamilyStatement2794 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_K_COLUMNFAMILY_in_dropColumnFamilyStatement2796 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_columnFamilyName_in_dropColumnFamilyStatement2800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DROP_in_dropIndexStatement2831 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_K_INDEX_in_dropIndexStatement2833 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_IDENT_in_dropIndexStatement2837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TRUNCATE_in_truncateStatement2868 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_columnFamilyName_in_truncateStatement2872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_GRANT_in_grantStatement2897 = new BitSet(new long[]{0x7009001000000020L});
    public static final BitSet FOLLOW_permissionOrAll_in_grantStatement2909 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_K_ON_in_grantStatement2917 = new BitSet(new long[]{0xC2025EA22141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_resource_in_grantStatement2929 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_K_TO_in_grantStatement2937 = new BitSet(new long[]{0x0000400000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_username_in_grantStatement2949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_REVOKE_in_revokeStatement2980 = new BitSet(new long[]{0x7009001000000020L});
    public static final BitSet FOLLOW_permissionOrAll_in_revokeStatement2992 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_K_ON_in_revokeStatement3000 = new BitSet(new long[]{0xC2025EA22141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_resource_in_revokeStatement3012 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_K_FROM_in_revokeStatement3020 = new BitSet(new long[]{0x0000400000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_username_in_revokeStatement3032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_LIST_in_listPermissionsStatement3070 = new BitSet(new long[]{0x7009001000000020L});
    public static final BitSet FOLLOW_permissionOrAll_in_listPermissionsStatement3082 = new BitSet(new long[]{0x0C00800000000002L});
    public static final BitSet FOLLOW_K_ON_in_listPermissionsStatement3092 = new BitSet(new long[]{0xC2025EA22141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_resource_in_listPermissionsStatement3094 = new BitSet(new long[]{0x0C00000000000002L});
    public static final BitSet FOLLOW_K_OF_in_listPermissionsStatement3109 = new BitSet(new long[]{0x0000400000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_username_in_listPermissionsStatement3111 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_K_NORECURSIVE_in_listPermissionsStatement3126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_permission3162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_ALL_in_permissionOrAll3211 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_K_PERMISSIONS_in_permissionOrAll3215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_permission_in_permissionOrAll3236 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_K_PERMISSION_in_permissionOrAll3240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dataResource_in_resource3268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_ALL_in_dataResource3291 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_K_KEYSPACES_in_dataResource3293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_KEYSPACE_in_dataResource3303 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_keyspaceName_in_dataResource3309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_COLUMNFAMILY_in_dataResource3321 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_columnFamilyName_in_dataResource3330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_CREATE_in_createUserStatement3370 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_K_USER_in_createUserStatement3372 = new BitSet(new long[]{0x0000400000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_username_in_createUserStatement3374 = new BitSet(new long[]{0x0000004000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_K_WITH_in_createUserStatement3384 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_userOptions_in_createUserStatement3386 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_K_SUPERUSER_in_createUserStatement3400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_NOSUPERUSER_in_createUserStatement3406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_ALTER_in_alterUserStatement3451 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_K_USER_in_alterUserStatement3453 = new BitSet(new long[]{0x0000400000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_username_in_alterUserStatement3455 = new BitSet(new long[]{0x0000004000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_K_WITH_in_alterUserStatement3465 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_userOptions_in_alterUserStatement3467 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_K_SUPERUSER_in_alterUserStatement3481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_NOSUPERUSER_in_alterUserStatement3487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DROP_in_dropUserStatement3523 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_K_USER_in_dropUserStatement3525 = new BitSet(new long[]{0x0000400000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_username_in_dropUserStatement3527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_LIST_in_listUsersStatement3552 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_K_USERS_in_listUsersStatement3554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_userOption_in_userOptions3574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_PASSWORD_in_userOption3595 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_userOption3599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_cident3628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_NAME_in_cident3653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unreserved_keyword_in_cident3672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cfOrKsName_in_keyspaceName3705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cfOrKsName_in_columnFamilyName3739 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_136_in_columnFamilyName3742 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_cfOrKsName_in_columnFamilyName3746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_cfOrKsName3767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_NAME_in_cfOrKsName3792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unreserved_keyword_in_cfOrKsName3811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_constant3836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_constant3848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_constant3867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_constant3888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UUID_in_constant3907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEXNUMBER_in_constant3929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_137_in_set_tail3954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_132_in_set_tail3962 = new BitSet(new long[]{0xC2025E022141D040L,0x00000000FFFEFFFFL,0x0000000000000844L});
    public static final BitSet FOLLOW_term_in_set_tail3966 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000210L});
    public static final BitSet FOLLOW_set_tail_in_set_tail3970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_137_in_map_tail3989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_132_in_map_tail3997 = new BitSet(new long[]{0xC2025E022141D040L,0x00000000FFFEFFFFL,0x0000000000000844L});
    public static final BitSet FOLLOW_term_in_map_tail4001 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_138_in_map_tail4003 = new BitSet(new long[]{0xC2025E022141D040L,0x00000000FFFEFFFFL,0x0000000000000844L});
    public static final BitSet FOLLOW_term_in_map_tail4007 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000210L});
    public static final BitSet FOLLOW_map_tail_in_map_tail4011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_139_in_map_literal4033 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_137_in_map_literal4035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_139_in_map_literal4045 = new BitSet(new long[]{0xC2025E022141D040L,0x00000000FFFEFFFFL,0x0000000000000844L});
    public static final BitSet FOLLOW_term_in_map_literal4061 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_138_in_map_literal4063 = new BitSet(new long[]{0xC2025E022141D040L,0x00000000FFFEFFFFL,0x0000000000000844L});
    public static final BitSet FOLLOW_term_in_map_literal4067 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000210L});
    public static final BitSet FOLLOW_map_tail_in_map_literal4071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_138_in_set_or_map4103 = new BitSet(new long[]{0xC2025E022141D040L,0x00000000FFFEFFFFL,0x0000000000000844L});
    public static final BitSet FOLLOW_term_in_set_or_map4107 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000210L});
    public static final BitSet FOLLOW_map_tail_in_set_or_map4111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_tail_in_set_or_map4124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_134_in_collection_literal4149 = new BitSet(new long[]{0xC2025E022141D040L,0x00000000FFFEFFFFL,0x00000000000008C4L});
    public static final BitSet FOLLOW_term_in_collection_literal4157 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000090L});
    public static final BitSet FOLLOW_132_in_collection_literal4163 = new BitSet(new long[]{0xC2025E022141D040L,0x00000000FFFEFFFFL,0x0000000000000844L});
    public static final BitSet FOLLOW_term_in_collection_literal4167 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000090L});
    public static final BitSet FOLLOW_135_in_collection_literal4177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_139_in_collection_literal4187 = new BitSet(new long[]{0xC2025E022141D040L,0x00000000FFFEFFFFL,0x0000000000000844L});
    public static final BitSet FOLLOW_term_in_collection_literal4191 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000610L});
    public static final BitSet FOLLOW_set_or_map_in_collection_literal4195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_139_in_collection_literal4211 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_137_in_collection_literal4213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_value4238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collection_literal_in_value4260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_NULL_in_value4270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QMARK_in_value4294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_functionName4334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unreserved_function_keyword_in_functionName4368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TOKEN_in_functionName4378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_functionArgs4423 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_131_in_functionArgs4425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_functionArgs4435 = new BitSet(new long[]{0xC2025E022141D040L,0x00000000FFFEFFFFL,0x0000000000000844L});
    public static final BitSet FOLLOW_term_in_functionArgs4439 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_132_in_functionArgs4455 = new BitSet(new long[]{0xC2025E022141D040L,0x00000000FFFEFFFFL,0x0000000000000844L});
    public static final BitSet FOLLOW_term_in_functionArgs4459 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_131_in_functionArgs4473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_value_in_term4498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionName_in_term4535 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_functionArgs_in_term4539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_term4549 = new BitSet(new long[]{0xC2021E0225404000L,0x00000000FFFE00FFL});
    public static final BitSet FOLLOW_comparatorType_in_term4553 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_131_in_term4555 = new BitSet(new long[]{0xC2025E022141D040L,0x00000000FFFEFFFFL,0x0000000000000844L});
    public static final BitSet FOLLOW_term_in_term4559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_columnOperation4582 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_140_in_columnOperation4584 = new BitSet(new long[]{0xC2025E022141D040L,0x00000000FFFEFFFFL,0x0000000000000844L});
    public static final BitSet FOLLOW_term_in_columnOperation4588 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_141_in_columnOperation4591 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_cident_in_columnOperation4595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_columnOperation4616 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_140_in_columnOperation4618 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_cident_in_columnOperation4622 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000006000L});
    public static final BitSet FOLLOW_set_in_columnOperation4626 = new BitSet(new long[]{0xC2025E022141D040L,0x00000000FFFEFFFFL,0x0000000000000844L});
    public static final BitSet FOLLOW_term_in_columnOperation4636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_columnOperation4654 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_140_in_columnOperation4656 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_cident_in_columnOperation4660 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_INTEGER_in_columnOperation4664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_columnOperation4682 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_134_in_columnOperation4684 = new BitSet(new long[]{0xC2025E022141D040L,0x00000000FFFEFFFFL,0x0000000000000844L});
    public static final BitSet FOLLOW_term_in_columnOperation4688 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_135_in_columnOperation4690 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_140_in_columnOperation4692 = new BitSet(new long[]{0xC2025E022141D040L,0x00000000FFFEFFFFL,0x0000000000000844L});
    public static final BitSet FOLLOW_term_in_columnOperation4696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_property_in_properties4722 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_K_AND_in_properties4726 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_property_in_properties4728 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_cident_in_property4751 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_140_in_property4753 = new BitSet(new long[]{0xC2025E022141D040L,0x00000000FFFE1FFFL,0x0000000000000800L});
    public static final BitSet FOLLOW_propertyValue_in_property4758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_literal_in_property4787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_propertyValue4815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unreserved_keyword_in_propertyValue4837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_140_in_relationType4860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_143_in_relationType4871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_144_in_relationType4882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_145_in_relationType4892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_146_in_relationType4903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_relation4925 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000079000L});
    public static final BitSet FOLLOW_relationType_in_relation4929 = new BitSet(new long[]{0xC2025E022141D040L,0x00000000FFFEFFFFL,0x0000000000000844L});
    public static final BitSet FOLLOW_term_in_relation4933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TOKEN_in_relation4943 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_130_in_relation4966 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_cident_in_relation4970 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_132_in_relation4976 = new BitSet(new long[]{0xC2025E022141C040L,0x00000000FFFE017FL});
    public static final BitSet FOLLOW_cident_in_relation4980 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_131_in_relation4986 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000079000L});
    public static final BitSet FOLLOW_relationType_in_relation4998 = new BitSet(new long[]{0xC2025E022141D040L,0x00000000FFFEFFFFL,0x0000000000000844L});
    public static final BitSet FOLLOW_term_in_relation5002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_relation5022 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_K_IN_in_relation5024 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_130_in_relation5035 = new BitSet(new long[]{0xC2025E022141D040L,0x00000000FFFEFFFFL,0x0000000000000844L});
    public static final BitSet FOLLOW_term_in_relation5039 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_132_in_relation5044 = new BitSet(new long[]{0xC2025E022141D040L,0x00000000FFFEFFFFL,0x0000000000000844L});
    public static final BitSet FOLLOW_term_in_relation5048 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_131_in_relation5055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_native_type_in_comparatorType5080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collection_type_in_comparatorType5096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_comparatorType5108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_ASCII_in_native_type5137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_BIGINT_in_native_type5151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_BLOB_in_native_type5164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_BOOLEAN_in_native_type5179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_COUNTER_in_native_type5191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DECIMAL_in_native_type5203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DOUBLE_in_native_type5215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_FLOAT_in_native_type5228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_INET_in_native_type5242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_INT_in_native_type5257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TEXT_in_native_type5273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TIMESTAMP_in_native_type5288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_UUID_in_native_type5298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_VARCHAR_in_native_type5313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_VARINT_in_native_type5325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TIMEUUID_in_native_type5338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_MAP_in_collection_type5362 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_143_in_collection_type5365 = new BitSet(new long[]{0xC2021E0225404000L,0x00000000FFFE00FFL});
    public static final BitSet FOLLOW_comparatorType_in_collection_type5369 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_132_in_collection_type5371 = new BitSet(new long[]{0xC2021E0225404000L,0x00000000FFFE00FFL});
    public static final BitSet FOLLOW_comparatorType_in_collection_type5375 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_145_in_collection_type5377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_LIST_in_collection_type5395 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_143_in_collection_type5397 = new BitSet(new long[]{0xC2021E0225404000L,0x00000000FFFE00FFL});
    public static final BitSet FOLLOW_comparatorType_in_collection_type5401 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_145_in_collection_type5403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_SET_in_collection_type5421 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_143_in_collection_type5424 = new BitSet(new long[]{0xC2021E0225404000L,0x00000000FFFE00FFL});
    public static final BitSet FOLLOW_comparatorType_in_collection_type5428 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_145_in_collection_type5430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_username0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unreserved_function_keyword_in_unreserved_keyword5488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_unreserved_keyword5504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_unreserved_function_keyword5539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_native_type_in_unreserved_function_keyword5779 = new BitSet(new long[]{0x0000000000000002L});

}