/*
 *--------------------------------------------------------
 * Administrateur
 *--------------------------------------------------------
 * Project     : fuzzBuzz
 *
 * Copyright Administrateur,  All Rights Reserved.
 *
 * This software is the confidential and proprietary
 * information of Administrateur.
 * You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms
 * of the license agreement you entered into with
 * Administrateur.
 *-------------------------------------------------------- 
 * 
 * Fichier 		:	FuzzBuzzTest.java
 * Cree le 		: 	3 sept. 2016 à 15:43:03
 * Auteur		: 	mmenhour
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.org.fuzz.FuzzBuzz;
import com.org.utlls.ConstantesUtils;

/**
 * A Renseigner.
 * @author  : admin
 * @project : fuzzBuzz
 * @package : com.org
 * @date    : 3 sept. 2016 15:43:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FuzzBuzzTest
{
   private static final Logger logger = LoggerFactory.getLogger( FuzzBuzzTest.class );
   
   @Autowired
   private FuzzBuzz            fuzzBuzz;
   
   @Before
   public void init()
   {
      try
      {
         Assert.assertNotNull( fuzzBuzz );
      }
      catch( Exception e )
      {
         logger.error( "Error ", e );
      }
   }
   
   @After
   public void destroy()
   {
      try
      {
         
      }
      catch( Exception e )
      {
         logger.error( "Error ", e );
      }
   }
   
   @Test
   public void fuzzBuzzTest()
   {
      String out = fuzzBuzz.fuzzBuzz( 1 );
      Assert.assertEquals( "1", out );
      out = fuzzBuzz.fuzzBuzz( 2 );
      Assert.assertEquals( "2", out );
      out = fuzzBuzz.fuzzBuzz( 3 );
      Assert.assertEquals( ConstantesUtils.FUZZ, out );
      out = fuzzBuzz.fuzzBuzz( 5 );
      Assert.assertEquals( ConstantesUtils.BUZZ, out );
      out = fuzzBuzz.fuzzBuzz( 15 );
      Assert.assertEquals( ConstantesUtils.FUZZ + ConstantesUtils.BUZZ, out );
      out = fuzzBuzz.fuzzBuzz( 7 );
      Assert.assertEquals( ConstantesUtils.BAZ, out );
      out = fuzzBuzz.fuzzBuzz( 21 );
      Assert.assertEquals( ConstantesUtils.FUZZ + ConstantesUtils.BAZ, out );
      out = fuzzBuzz.fuzzBuzz( 105 );
      Assert.assertEquals( ConstantesUtils.FUZZ + ConstantesUtils.BUZZ + ConstantesUtils.BAZ, out );
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void fuzzBuzzExceptionTest_1()
   {
      fuzzBuzz.fuzzBuzz( 0 );
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void fuzzBuzzExceptionTest_2()
   {
      fuzzBuzz.fuzzBuzz( -1 );
   }
}
