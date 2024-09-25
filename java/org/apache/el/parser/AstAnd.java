/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/* Generated By:JJTree: Do not edit this line. AstAnd.java */
package org.apache.el.parser;

import jakarta.el.ELException;

import org.apache.el.lang.ELSupport;
import org.apache.el.lang.EvaluationContext;

/**
 * @author Jacob Hookom [jacob@hookom.net]
 */
public final class AstAnd extends BooleanNode {

    public AstAnd(int id) {
        super(id);
    }


    @Override
    public Object getValue(EvaluationContext ctx) throws ELException {
        int i = 0;
        while (i < children.length - 1) {
            Object obj = children[i].getValue(ctx);
            Boolean b = ELSupport.coerceToBoolean(ctx, obj, true);
            if (!b.booleanValue()) {
                return b;
            }
            i++;
        }
        Object obj = children[i].getValue(ctx);
        return ELSupport.coerceToBoolean(ctx, obj, true);
    }
}
