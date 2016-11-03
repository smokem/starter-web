package irdeto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public enum Streams {
    
    ALL("ALL",00000000),
    epg_data_stream_transition_delete_ts ("epg-data-stream-transition-delete.ts",00000000),
   
    /**
     * Stream with services being added or removed one at a time. Can be looped.
     * Time intervals and services existence associated with (configuration index) : <br>
     * [0..60] -> [10..20] (1)<br>
     * [61..120] -> [10..19] (2)<br>
     * [120..180] -> [10..14,16..19] (3)<br>
     * [180..240] -> [11..14,16..19] (4)<br>
     * [240..300] -> [10..14,16..19] (3)<br>
     * [300..375] -> [10..19] (2)<br>
     */
    PDC__SDT_Update_TS2__v1_0 ("PDC__SDT_Update_TS2__v1_0.ts", 0/*TODO*/, "2014-01-22 15:19:15 GMT", "00:06:15"),

    /*------------------------------------------------------------------------*
     * Streams for TTX and DVB subtitles
     *------------------------------------------------------------------------*/
    /** {@value}<BR/>
     * Stream containing TTX and DVB subtitles introduced on 2014/2/11 for execution of embedded tests<BR/>
     */
    
    PDC_ASTRA_TV5Monde__Subtitles_2TTX_7DVB_FEC56_Symb22000__20140211_1705 ("PDC-ASTRA-TV5Monde__Subtitles-2TTX-7DVB-FEC56_Symb22000__20140211-1705.ts",22000000,"",""),
    /** {@value}<BR/>
     * Version v2 of the stream was introduced 17 december in order to fix SCR#241418<BR/>
     * Version v3 of the stream was introduced in January 2014 for LoaderV5 / SSU Signalization<BR/>
     * Version v4: Included SSU OTA id=25 to test fix for SCR#307406<BR/>
     * A typical service: dvb://1.2.ce
     * @TODO : Date and duration is not correct
     */
    PDC_LAB_RecordedTS2_OTA ("PDC/test_streams/PDC__OTA__v4_0/PDC__LAB_TS2_OTA__v4.ts", 20549686, "2014-01-01 00:00:00 GMT", "00:10:00"),

    /** {@value}<BR/>
     * Version v2 of the stream was introduced 17 december in order to fix SCR#241418<BR/>
     * Version v3 of the stream was introduced in January 2014 for LoaderV5 / SSU Signalization<BR/>
     * Version v4: Included SSU OTA id=25 to test fix for SCR#307406<BR/>
     * A typical service: dvb://1.3.132
     * @TODO : Date and duration is not correct
     */
    PDC_LAB_RecordedTS3_OTA ("PDC/test_streams/PDC__OTA__v4_0/PDC__LAB_TS3_OTA__v4.ts", 20000000, "2014-01-01 00:00:00 GMT", "00:10:00"),

    /**
     * Test stream (TS1) for GenericSSU OTA (BBCL) 
     */
    PDC_LAB_BBCLOTA_TS1 ("PDC/test_streams/PDC__BBCLOTA/PDC__BBCLOTA_TS1.ts", 25000000, "2014-01-01 00:00:00 GMT", "00:10:00"),
    
    /**
     * Test stream (TS2) for GenericSSU OTA (BBCL) 
     */
    PDC_LAB_BBCLOTA_TS2 ("PDC/test_streams/PDC__BBCLOTA/PDC__BBCLOTA_TS2.ts", 25000000, "2014-01-01 00:00:00 GMT", "00:10:00"),
    
    
    /** {@value}<BR/>
     * Version of the stream used to check audio and subtitle languages on EITs for MHEG5 languages APIs<BR/>
     */
    Flx0104_m2t ("Flx0104.m2t",0),

    /** {@value}<BR/>
     * Recorded from French Live, can be used for any purposes when a foreign TS is needed.<BR/>
     * A typical service: dvb://20fa.6.601
     * @TODO : Date and duration is not correct
     */
    TF1 ("PDC/test_streams/PDC__OTA__v4_0/Video_TF1-TTX-SUB_Fec=56_Symb=22000.ts", 24128317, "2014-01-01 00:00:00 GMT", "00:10:00"),
    
    /*------------------------------------------------------------------------*
     * Streams for Channel Zapping and all PVR test cases (Explora)
     *------------------------------------------------------------------------*/
    
//    /** {@value}<BR/>
//     * Version v1 of the stream was introduced 28 January 2014 to execute NxtGen PVR test suite (including new zapping test cases)<BR/>
//     * EITpf on service: dvb://1.1.b
//     * Rate used by the injector or stream player TS:42 250 000 (mandatory)
//     */
     IMW_PDC_KMSTS1__PVRSearchPVZapping__v1_0("IMW-PDC-KMSTS1__PVRSearchPVZapping__v1_0.ts", 42250000, "2014-01-27 16:00:12 GMT", "00:27:00"),
    
    /** {@value}<BR/>
     * Version v1 of the stream was introduced 28 January 2014 to execute NxtGen PVR test suite (including new zapping test cases)<BR/>
     * Channel locked and country blocked
     * Rate used by the injector or stream player TS 20 550 000 (mandatory)
     */
    IMW_PDC_KMSTS2__PVRSearchPVZapping__v1_0 ("IMW-PDC-KMSTS2__PVRSearchPVZapping__v1_0.ts", 42250000, "2014-01-27 16:00:12 GMT", "00:27:00"),


    /*---------------------------------------------------------*
     * Streams for Parental Control   (v1_3 Latest test stream)
     *---------------------------------------------------------*/
    /**
     * {@value}<BR/>
     * 
     * Version of stream used to execute Parental lock test cases included in the NxtGen PVR test suite.
     * 
     */
    IMW_PDC_LAB_TS3_Parental_Control_v1_3 ("IMW-PDC-LAB-TS3__Parental-Control__v1_3.ts",20000000,"2014-04-10 16:00:12 GMT","00:10:44"),

    PDC__Parental_Control_TS1__v2_0 ("PDC/test_streams/PDC__Parental_Control_TS1__v2_0/PDC__Parental_Control_TS1__v2_0.ts", -1, "2014-04-10 16:00:12 GMT", "00:10:44"),

    /** {@value}<BR/>
     * Version of the stream used to check AC3 audio outputs<BR/>
     */
    DTT_HD_Service_TS1_3_Oct_ts ("DTT_HD_Service_TS1_3_Oct.ts",0),


    /*------------------------------------------------------------------------*
     * Streams for DDP
     *------------------------------------------------------------------------*/

    /** TS1 of streams for the DDP test xlets */
    PDC__DDP_TS1__v1_1("PDC__DDP_TS1__v1_1.ts", 42250000, "2014-02-04 16:18:22 GMT", "00:13:55" ),
    /** TS2 of streams for the DDP test xlets */
    PDC__DDP_TS2__v1_1("PDC__DDP_TS2__v1_1.ts", 20500000, "2014-02-04 16:18:22 GMT", "00:13:55" ),

    /** Version 2 of DDP test stream (generated using OpenCaster) */
    PDC__DDP_TS1__v2_0("PDC__DDP_TS1__v2_0.ts", 18800000, "2015-05-20 11:00:00 GMT", "00:02:00" ),

    /** DDP test stream with 5 carousels at 1 MB/s each (generated using OpenCaster) */
    PDC__DDP_BigData_TS1__v1_0("PDC__DDP_BigData_TS1__v1_0.ts", 18800000, "2015-08-24 16:30:00 GMT", "00:00:30" ),

    /** TS1 of streams for the DDP test xlets with DST only present on TS1 */
    PDC__DDP_one_DST_TS1__v1_1("PDC__DDP_one_DST_TS1__v1_0.ts", 42250000, "2014-02-04 16:24:38 GMT", "00:04:00" ),
    /** TS2 of streams for the DDP test xlets with DST only present on TS1 */
    PDC__DDP_one_DST_TS2__v1_1("PDC__DDP_one_DST_TS2__v1_0.ts", 20500000, "2014-02-04 16:24:38 GMT", "00:04:00" ),

    /**  DDP test xlets with BAT absent for 1 minute between 1:30 and 2:30 */
    PDC__DDP_no_BAT__v1_0("PDC__DDP_no_BAT__v1_0.ts", 42250000, "2014-02-04 16:24:38 GMT", "00:04:00" ),
    

    /*------------------------------------------------------------------------*
     * Streams for EPG Data Stream
     *------------------------------------------------------------------------*/

    /** TS1 of streams for the EPG test xlets */
    PDC__EPGDS_TS1__v1_1("PDC__EPGDS_TS1__v1_1.ts", 42250000, "2014-02-19 14:22:23 GMT", "00:04:29"),
    /** TS2 of streams for the EPG test xlets */
    PDC__EPGDS_TS2__v1_1("PDC__EPGDS_TS2__v1_1.ts", 20500000, "2014-02-19 14:22:23 GMT", "00:04:29"), 

    /** TS1 of streams for the EPG test xlets with DST only present on TS1 */
    PDC__EPGDS_one_DST_TS1__v1_1("PDC__EPGDS_one_DST_TS1__v1_1.ts", 42250000, "2014-02-19 14:22:23 GMT", "00:04:29"),
    /** TS2 of streams for the EPG test xlets with DST only present on TS1 */
    PDC__EPGDS_one_DST_TS2__v1_1("PDC__EPGDS_one_DST_TS2__v1_1.ts", 20500000, "2014-02-19 14:22:23 GMT", "00:04:29"), 

    /** to test series with event update */
    IMW_PDC_LAB_PDC_TS1__EPGDataCarrousel_Series_EventUpdateDelete__v1_0 ("PDC_TS1__EPGDataCarrousel_Series_EventUpdateDelete.ts",0),


    /*------------------------------------------------------------------------*
     * Streams for SoftCell DVT
     *------------------------------------------------------------------------*/

    /** SoftCell DVT used to test 911 mode descrambling (see doc#737549) */
    DVT__911Mode__V2_5("IRDMessage_911Mode_V2.5.mpg", 22100000 , "2008-01-01 00:00:00 GMT" , "00:02:00"),

    /** SoftCell DVT stream used to test component level scrambling (each elementary stream is associated to a dedicated ECM pid - see doc#737549) */
    DVT__CompLevelScramble__V2_5("CompLevelScramble_V2.5.mpg", 22100000 , "2008-01-01 00:00:00 GMT" , "00:02:20"),

    /** SoftCell DVT stream used to test HD service decoding, multiple audio components and DVB-CSA2 descrambling (see doc#737549) */
    DVT__DecoderTest__V2_5("DecoderTest_V2.5.mpg", 22100000 , "2008-01-01 00:00:00 GMT" , "00:02:30"),

    /** SoftCell DVT stream used to test service blockout via EMM product, descrambling using different products on multiple sectors,
     * descrambling with 10 different products, Service status screen and CA state transition (see doc#737549) */
    DVT__DriverTest__V2_5("DriverTest_V2.5.mpg", 22100000 , "2008-01-01 00:00:00 GMT" , "00:05:20"),

    /** SoftCell DVT stream used to test EMM stress and soaking, announcement/mail and STB stability (see doc#737549). This stream holds 5 services */
    DVT__EMMStressSoakTest__V3_9("EMMStressSoakTest_V3_9.mpg", 22100000 , "2008-01-01 00:00:00 GMT" , "00:02:00"),

    /** New flavour of {@link #DVT__EMMStressSoakTest__V3_9}, but with 2 services instead of 5, 1Mbit/s EMM pid and PVR entitlements  */
    DVT__EMMStressSoak_1M__V3_12_6("EMMStressSoak_1M_V3.12.6.mpg", 22100000 , "2008-01-01 00:00:00 GMT" , "00:02:00"),

    /** SoftCell DVT stream used to test ECM and TMS fingerprint reception and handling (see doc#737549) */
    DVT__FingerPrinting__V2_5("FingerPrinting_V2.5.mpg", 22100000 , "2008-01-01 00:00:00 GMT" , "00:03:40"),

    /** SoftCell DVT stream used to test the priority of CA errors and service running status in SDT (see doc#737549) */
    DVT__RunningStatus__V2_5("RunningStatus_V2.5.mpg", 22100000 , "2008-01-01 00:00:00 GMT" , "00:04:00"),

    /** SoftCell DVT stream used to test basic descrambling, PMT update/CA state transition and smart card status screen (see doc#737549) */
    DVT__StatusDisplay__V2_5("StatusDisplay_V2.5.mpg", 22100000 , "2008-01-01 00:00:00 GMT" , "00:01:40"),
    DVT__StatusDisplay__V3_3("StatusDisplay_V3.3.mpg", 22100000 , "2008-01-01 00:00:00 GMT" , "00:01:40"),

    /** SoftCell DVT used to test Homing Channel EMM reception with DVB-S transponder parameters (see doc#737549) */
    DVT__HomingChannel__V2_5("HomingChannel_V2.5.mpg", 22100000 , "2008-01-01 00:00:00 GMT" , "00:00:50"),

    /** SoftCell DVT stream used to test Homing Channel EMM reception with DVB-S2 transponder parameters (see doc#737549) */
    DVT__HomingChannel_DVBS2__V2_5("HomingChannel_DVBS2_V2.5.mpg", 22100000 , "2008-01-01 00:00:00 GMT" , "00:00:50"),

    /** SoftCell DVT stream used to test parental pin code EMM notifications (see doc#737549) */
    DVT__IRDMessage_00__V3_12_5("IRDMessage_00_V3.12.5.mpg", 22100000 , "2008-01-01 00:00:00 GMT" , "00:05:00"),

    /** SoftCell DVT stream used to test parental pin code EMM notifications (see doc#737549) */
    DVT__IRDMessage_01_MsgType04__V2_5("IRDMessage_01_MsgType04_V2.5.mpg", 22100000 , "2008-01-01 00:00:00 GMT" , "00:00:50"),

    /** SoftCell DVT stream used to test GRESET/SRESET EMM notifications (see doc#737549) */
    DVT__IRDMessage_01_MsgType05_Recovery00__V2_5("IRDMessage_01_MsgType05_Recovery00_V2.5.mpg", 22100000 , "2008-01-01 00:00:00 GMT" , "00:04:50"),

    /** SoftCell DVT stream used to test "Reset Channel Order" EMM notifications (see doc#737549) */
    DVT__IRDMessage_01_MsgType05_Recovery01__V2_5("IRDMessage_01_MsgType05_Recovery01_V2.5.mpg", 22100000 , "2008-01-01 00:00:00 GMT" , "00:00:50"),

    /** SoftCell DVT stream used to test "Re-Scan Service Information and Reset Channel Order" EMM notifications (see doc#737549) */
    DVT__IRDMessage_01_MsgType05_Recovery02__V2_5("IRDMessage_01_MsgType05_Recovery02_V2.5.mpg", 22100000 , "2008-01-01 00:00:00 GMT" , "00:04:50"),

    /** SoftCell DVT stream used to test "Reconnect to current service" EMM notifications (see doc#737549) */
    DVT__IRDMessage_01_MsgType05_Recovery04__V2_5("IRDMessage_01_MsgType05_Recovery04_V2.5.mpg", 22100000 , "2008-01-01 00:00:00 GMT" , "00:00:50"),

    /** SoftCell DVT stream used to test "Force tune to specific service" EMM notifications (see doc#737549) */
    DVT__IRDMessage_01_MsgType05_Recovery05__V2_5("IRDMessage_01_MsgType05_Recovery05_V2.5.mpg", 22100000 , "2008-01-01 00:00:00 GMT" , "00:00:50"),

    /** SoftCell DVT stream used to test "Force set installer PIN code" EMM notifications (see doc#737549) */
    DVT__IRDMessage_01_MsgType05_Recovery06__V2_5("IRDMessage_01_MsgType05_Recovery06_V2.5.mpg", 22100000 , "2008-01-01 00:00:00 GMT" , "00:00:50"),

    /** SoftCell DVT stream used to test EMMs targeted to a given network (see doc#737549) */
    DVT__TMSTest_network__V2_5("TMSTest_network_V2.5.mpg", 22100000 , "2008-01-01 00:00:00 GMT" , "00:00:50"),

    /** SoftCell DVT stream used to test EMMs targeted to a given transport stream (see doc#737549) */
    DVT__TMSTest_transport__V2_5("TMSTest_transport_V2.5.mpg", 22100000 , "2008-01-01 00:00:00 GMT" , "00:00:50"),

    /** SoftCell DVT stream used to test EMMs targeted to a given network (see doc#737549) */
    DVT__TMSTest_service__V2_5("TMSTest_service_V2.5.mpg", 22100000 , "2008-01-01 00:00:00 GMT" , "00:00:50"),

    /** CloakedCA DVT stream used to initialize the STB (see doc#735271) */
    CCADVT__Init("DVT_Init.ts", 22100000 , "2008-01-01 00:00:00 GMT" , "00:00:80"),

    /** CloakedCA DVT stream used to verify whether the status screens work correctly (see doc#735271) */
    CCADVT__StatusScreen("DVT_StatusScreen.ts", 22100000 , "2008-01-01 00:00:00 GMT" , "00:00:60"),

    /** CloakedCA DVT stream used to verify the EMM and ECM triggered fingerprint message (see doc#735271) */
    CCADVT__FingerPrint("DVT_FingerPrint.ts", 22100000 , "2008-01-01 00:00:00 GMT" , "00:00:70"),

    /** CloakedCA DVT stream used to verify IRD text messages reception and display (see doc#735271) */
    CCADVT__TextMessage("DVT_TextMessage.ts", 22100000 , "2008-01-01 00:00:00 GMT" , "00:00:30"),

    /** CloakedCA DVT stream used to verify attributed display normal and forced text messages (see doc#735271) */
    CCADVT__ADMTextMessage("DVT_ADMTextMessage.ts", 22100000 , "2008-01-01 00:00:00 GMT" , "00:00:50"),

    IMW_PDC__ChangeLanguages("StatusDisplay_V2.5-ZZZAF-BBBEL.mpg", 22100000 , "2008-01-01 00:00:00 GMT" , "00:01:00"),

    IMW_PDC__SetZafNationality("StatusDisplay_V2.5-ZAF.mpg", 22100000 , "2008-01-01 00:00:00 GMT" , "00:00:10"),

    /**
     * Italian stream used mainly for xlets testing<P/>
     * TS locator: dvb://110.384<BR/>
     * 
     * Some services:
     * <UL>
     * <LI> Canale 50: dvb://110.384.b
     * <LI> Radio Italia: dvb://110.384.f
     * </UL> 
     */
    IMW_ITA_Canale50("ITADTT/ITADTT__Canal50_C5_DTT__050624.ts", -1, "2008-01-01 00:00:00 GMT" , "00:00:10"),

    /**
     * MHEG5 test stream, it contains a service_attribute_descriptor ...<BR/>
     * A service_attribute_descriptor (in the NIT) is provided and lists following services (only):
     * <UL>
     * <LI>3.10.6.2-s0136 : numeric_selection_flag=false, visible_service_flag=false
     * <LI>3.10.6.2-s0137 : numeric_selection_flag=false, visible_service_flag=true
     * <LI>3.10.6.2-s0138 : numeric_selection_flag=false, visible_service_flag=false
     * </UL>
     */
    RDC_MHEG5_DTG_MHEGTS_MAIN_SA_V7_50("dtg_mhegts_main(sa)_v7.50.ts", 24128342, "2008-01-01 00:00:00 GMT" , "00:00:10"),    
    /**
     * HomeNetWorking test stream, this stream is use for the smooth Streaming
     * Elemental_H264_AAC_HE_LATM_188mult_sdt_pat_v3.mpg
     * <LI>A typical service: dvb://1.1.1 SSP
     * 
     */
    
    Elemental_H264_AAC_HE_LATM_188mult_sdt_pat_v3("Elemental_H264_AAC_HE_LATM_188mult_sdt_pat_v3_tdt.mpg", 22000000, "2008-09-18 11:24:24 GMT" , "00:00:03"),

    /**
     * LCN test stream with two LCN descriptors within a same TS
     */
    PDC__SERVICEPLAN_NUMBERING_TS1__v1_0("PDC__SERVICEPLAN_NUMBERING_TS1__v1_0", 26126471, "2015-05-20 11:00:00 GMT" , "00:02:00"),

    /**
     * A stream with a service name change in the middle 
     */
    PDC__SAT_SERVICEPLAN_UPDATES_SERVICENAME("PDC__SAT-SERVICEPLAN-UPDATES-SERVICENAME.ts", 18800000, "2015-05-20 11:00:00 GMT" , "00:02:00"),

    /**
     * KMS recorded stream, with 
     */
    IMW_PDC_LCNV2_TS2("LCNV2_TS2.ts", 20549709, "2008-01-01 00:00:00 GMT" , "00:00:50"),
    IMW_PDC_LCNV2_TS3("LCNV2_TS3.ts", 20000000, "2008-01-01 00:00:00 GMT" , "00:00:50"),
    
    /**
     * Streams generated with OpenCaster, for multiple purposes:
     * - blacklisted services
     * - service-name changes (SDT updates)
     * - EIT monitoring (present event changes every minutes)
     * - ...
     */
    PDC__MZ_TEST_STREAM_TS1("PDC__MZ_TEST_STREAM_TS1.ts", 26346021, "2008-01-01 00:00:00 GMT" , "00:00:50"),    
    /*
     *Create a new stream for testing the PVR recording conflict resolution , with the help of the stream 
     *we can test the time based and event abased recording schedule
     */
    PVR_HORIZ_OUTPUT("horiz_output.ts", 200000000, "2015-01-07 00:00:0 GMT", "00:9:56" );
    
    
    
    public final String STREAM_START_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss z";

    private final DateFormat startDateFormat = new SimpleDateFormat(STREAM_START_DATE_FORMAT);
    
    /**
     * 
     * @param fileName stream file name
     * @param bitRate  bitrate used for playing the stream
     */
    Streams(String fileName, int bitRate){
        this.fileName = fileName;
        this.bitRate = bitRate;        
    }
    
    /**
     * 
     * @param fileName stream file name
     * @param bitRate bitrate used for playing the stream
     * @param startDate starting date
     * @param duration stream duration
     */
    Streams(String fileName, int bitRate, String startDate, String duration) {
        TimeZone utcTimeZone = TimeZone.getTimeZone("UTC");
        startDateFormat.setTimeZone(utcTimeZone);
        this.fileName = fileName;
        this.bitRate = bitRate;  
        Date parsedStartDate = null;
        try {
            parsedStartDate = startDateFormat.parse(startDate);
        } catch (ParseException e) {
//            LOG.error("badly formed stream start date for " + fileName + " : " + startDate
//                               + " (format to follow is: " + STREAM_START_DATE_FORMAT + ")", e);
        }
        long durationMs = 0;
        try {
            //durationMs = DateUtil.parseDuration(duration);
            durationMs = 1;
        } catch (Exception e) {
            // can get a IllegalArgumentException or NumberFormatException for DateUtil.parseDuration().
            //LOG.error("badly formed stream duration for " + fileName + " : " + duration, e);
        } 
        if (parsedStartDate == null || durationMs == 0) {
            this.startDate = new Date();
            this.duration = 0;
        } else {
            this.startDate = parsedStartDate;
            this.duration = durationMs;
        }
    }
    
    private String fileName;
    private int bitRate;
    private Date startDate;
    private long duration;   

    
    /**
     * used to return the stream file name (with extention, .ts, .mpeg, etc.)
     * @return String stream file name
     */
    public String getFileName() {
        return fileName;
    }
    
    /**
     * return Bit Rate for playing the stream
     * @return int bit rate
     */
    public int getBitRate() {
        return bitRate;
    }
    
    /**
     * return the stream start date
     * @return Date stream start date
     */
    public Date getStartDate() {
        return startDate;
    }
    
    /**
     * return stream duration 
     * @return long stream duration
     */
    public long getDuration() {
        return duration;
    }
    
    /**
     * return stream file name
     */
    public String toString() {
        return fileName;
    }
    
}
