namespace viducWMS
{
    partial class wf_TrasladoInterno
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.btnSalir = new System.Windows.Forms.Button();
            this.dgListadProductos = new System.Windows.Forms.DataGrid();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.txtConfUbicacion = new System.Windows.Forms.TextBox();
            this.txtCodProducto = new System.Windows.Forms.TextBox();
            this.txtUbicacionOrigen = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.txtUnidades = new System.Windows.Forms.TextBox();
            this.lbTitulo = new System.Windows.Forms.Label();
            this.chkTodos = new System.Windows.Forms.CheckBox();
            this.SuspendLayout();
            // 
            // btnSalir
            // 
            this.btnSalir.BackColor = System.Drawing.Color.Navy;
            this.btnSalir.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.btnSalir.ForeColor = System.Drawing.Color.White;
            this.btnSalir.Location = new System.Drawing.Point(154, 264);
            this.btnSalir.Name = "btnSalir";
            this.btnSalir.Size = new System.Drawing.Size(82, 30);
            this.btnSalir.TabIndex = 4;
            this.btnSalir.Text = "Cancelar";
            this.btnSalir.Click += new System.EventHandler(this.btnSalir_Click);
            // 
            // dgListadProductos
            // 
            this.dgListadProductos.BackColor = System.Drawing.Color.White;
            this.dgListadProductos.BackgroundColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(128)))), ((int)(((byte)(128)))));
            this.dgListadProductos.ForeColor = System.Drawing.Color.Black;
            this.dgListadProductos.HeaderForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
            this.dgListadProductos.Location = new System.Drawing.Point(5, 136);
            this.dgListadProductos.Name = "dgListadProductos";
            this.dgListadProductos.Size = new System.Drawing.Size(231, 126);
            this.dgListadProductos.TabIndex = 3;
            // 
            // label4
            // 
            this.label4.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom)
                        | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.label4.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.label4.ForeColor = System.Drawing.Color.Navy;
            this.label4.Location = new System.Drawing.Point(8, 37);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(102, 13);
            this.label4.Text = "Ubicación origen:";
            this.label4.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // label3
            // 
            this.label3.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom)
                        | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.label3.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.label3.ForeColor = System.Drawing.Color.Navy;
            this.label3.Location = new System.Drawing.Point(22, 59);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(87, 17);
            this.label3.Text = "Cód producto:";
            this.label3.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // label2
            // 
            this.label2.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom)
                        | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.label2.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.label2.ForeColor = System.Drawing.Color.Navy;
            this.label2.Location = new System.Drawing.Point(1, 104);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(106, 16);
            this.label2.Text = "Ubicación destino:";
            this.label2.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // txtConfUbicacion
            // 
            this.txtConfUbicacion.Location = new System.Drawing.Point(111, 99);
            this.txtConfUbicacion.Name = "txtConfUbicacion";
            this.txtConfUbicacion.Size = new System.Drawing.Size(125, 21);
            this.txtConfUbicacion.TabIndex = 3;
            this.txtConfUbicacion.KeyUp += new System.Windows.Forms.KeyEventHandler(this.txtConfUbicacion_KeyUp);
            // 
            // txtCodProducto
            // 
            this.txtCodProducto.Location = new System.Drawing.Point(111, 55);
            this.txtCodProducto.Name = "txtCodProducto";
            this.txtCodProducto.Size = new System.Drawing.Size(125, 21);
            this.txtCodProducto.TabIndex = 1;
            this.txtCodProducto.KeyUp += new System.Windows.Forms.KeyEventHandler(this.txtCodProducto_KeyUp);
            // 
            // txtUbicacionOrigen
            // 
            this.txtUbicacionOrigen.Location = new System.Drawing.Point(111, 33);
            this.txtUbicacionOrigen.Name = "txtUbicacionOrigen";
            this.txtUbicacionOrigen.Size = new System.Drawing.Size(125, 21);
            this.txtUbicacionOrigen.TabIndex = 0;
            this.txtUbicacionOrigen.KeyUp += new System.Windows.Forms.KeyEventHandler(this.txtUbicacionOrigen_KeyUp);
            // 
            // label5
            // 
            this.label5.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom)
                        | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.label5.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.label5.ForeColor = System.Drawing.Color.Navy;
            this.label5.Location = new System.Drawing.Point(9, 83);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(100, 13);
            this.label5.Text = "Confir. unidades:";
            this.label5.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // txtUnidades
            // 
            this.txtUnidades.Location = new System.Drawing.Point(111, 77);
            this.txtUnidades.Name = "txtUnidades";
            this.txtUnidades.Size = new System.Drawing.Size(125, 21);
            this.txtUnidades.TabIndex = 2;
            this.txtUnidades.KeyUp += new System.Windows.Forms.KeyEventHandler(this.txtUnidades_KeyUp);
            // 
            // lbTitulo
            // 
            this.lbTitulo.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.lbTitulo.ForeColor = System.Drawing.Color.Navy;
            this.lbTitulo.Location = new System.Drawing.Point(43, 2);
            this.lbTitulo.Name = "lbTitulo";
            this.lbTitulo.Size = new System.Drawing.Size(169, 14);
            // 
            // chkTodos
            // 
            this.chkTodos.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.chkTodos.ForeColor = System.Drawing.Color.Navy;
            this.chkTodos.Location = new System.Drawing.Point(107, 11);
            this.chkTodos.Name = "chkTodos";
            this.chkTodos.Size = new System.Drawing.Size(125, 20);
            this.chkTodos.TabIndex = 5;
            this.chkTodos.Text = "Ubicación todos";
            this.chkTodos.Visible = false;
            this.chkTodos.Click += new System.EventHandler(this.chkSeleccion_Click);
            // 
            // wf_TrasladoInterno
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(96F, 96F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Dpi;
            this.AutoScroll = true;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            this.ClientSize = new System.Drawing.Size(240, 294);
            this.Controls.Add(this.chkTodos);
            this.Controls.Add(this.lbTitulo);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.txtConfUbicacion);
            this.Controls.Add(this.txtCodProducto);
            this.Controls.Add(this.txtUbicacionOrigen);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.txtUnidades);
            this.Controls.Add(this.btnSalir);
            this.Controls.Add(this.dgListadProductos);
            this.Name = "wf_TrasladoInterno";
            this.Text = "Traslado interno";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btnSalir;
        private System.Windows.Forms.DataGrid dgListadProductos;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtConfUbicacion;
        private System.Windows.Forms.TextBox txtCodProducto;
        private System.Windows.Forms.TextBox txtUbicacionOrigen;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox txtUnidades;
        private System.Windows.Forms.Label lbTitulo;
        private System.Windows.Forms.CheckBox chkTodos;
    }
}