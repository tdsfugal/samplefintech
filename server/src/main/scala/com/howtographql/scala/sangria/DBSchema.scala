package com.howtographql.scala.sangria

import slick.jdbc.H2Profile.api._

import scala.concurrent.duration._
import scala.concurrent.Await
import scala.language.postfixOps

import com.howtographql.scala.sangria.models._

object DBSchema {

  class LoansTable(tag: Tag) extends Table[Loan](tag, "LOANS"){
    def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)
    def url =  column[String]("URL")
    def description = column[String]("DESCRIPTION")

    def * = (id, url, description).mapTo[Loan]
  }

  val Loans = TableQuery[LoansTable]

  val databaseSetup = DBIO.seq(
    Loans.schema.create,

    Loans forceInsertAll Seq(
      Loan(1, "http://howtographql.com", "Awesome community driven GraphQL tutorial"),
      Loan(2, "http://graphql.org", "Official GraphQL web page"),
      Loan(3, "https://graphql.org/", "GraphQL specificiation")
    )
  )

  def createDatabase: DAO = {
    val db = Database.forConfig("h2mem")

    Await.result(db.run(databaseSetup), 10 seconds)

    new DAO(db)

  }

}

case class MyContext(dao: DAO) {

}
