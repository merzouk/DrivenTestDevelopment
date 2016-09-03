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
 * Fichier 		:	FuzzBuzz.java
 * Cree le 		: 	3 sept. 2016 à 14:53:00
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.fuzz.impl;

import org.springframework.stereotype.Service;

import com.org.fuzz.FuzzBuzz;
import com.org.utlls.ConstantesUtils;

/**
 * A Renseigner.
 * @author  : admin
 * @project : fuzzBuzz
 * @package : com.org
 * @date    : 3 sept. 2016 14:53:00
 */
@Service
public class FuzzBuzzImpl implements FuzzBuzz
{
   /**
    * 
    * @see com.org.fuzz.FuzzBuzz#fuzzBuzz(int)
    */
   @Override
   public String fuzzBuzz( int value ) throws IllegalArgumentException
   {
      if( value <= 0 )
      {
         throw new IllegalArgumentException( "The input value is not correct" );
      }
      String out = "";
      if( value == 1 )
      {
         out += "1";
      }
      if( value == 2 )
      {
         out += "2";
      }
      if( value % 3 == 0 )
      {
         out += ConstantesUtils.FUZZ;
      }
      if( value % 5 == 0 )
      {
         out += ConstantesUtils.BUZZ;
      }
      if( value % 7 == 0 )
      {
         out += ConstantesUtils.BAZ;
      }
      return out;
   }
}
