// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.apache.doris.nereids.trees.expressions.literal;

import org.apache.doris.analysis.LiteralExpr;
import org.apache.doris.nereids.exceptions.AnalysisException;
import org.apache.doris.nereids.types.DataType;

/** MaxLiteral */
public class MaxLiteral extends Literal implements ComparableLiteral {
    public MaxLiteral(DataType dataType) {
        super(dataType);
    }

    @Override
    public Object getValue() {
        throw new AnalysisException("Can not get value from max literal");
    }

    @Override
    public LiteralExpr toLegacyLiteral() {
        return org.apache.doris.analysis.MaxLiteral.MAX_VALUE;
    }

    @Override
    public int compareTo(ComparableLiteral other) {
        if (other instanceof MaxLiteral) {
            return 0;
        }
        return 1;
    }

    @Override
    public String computeToSql() {
        return "MAX_VALUE";
    }

    @Override
    public String toString() {
        return "MAX_VALUE";
    }
}
