package com.howtographql.scala.sangria

import sangria.schema.{Field, ListType, ObjectType}
import models._
// #
import sangria.schema._
import sangria.macros.derive._

object GraphQLSchema {

  val LoanType = ObjectType[Unit, Loan](
       "Link",
       fields[Unit, Loan](
         Field("id", IntType, resolve = _.value.id),
         Field("url", StringType, resolve = _.value.url),
         Field("description", StringType, resolve = _.value.description)
       )
     )

  val QueryType = ObjectType(
    "Query",
    fields[MyContext, Unit](
      Field("allLoans", ListType(LoanType), resolve = c => c.ctx.dao.allLoans)
    )
  )

  val SchemaDefinition = Schema(QueryType)
}
